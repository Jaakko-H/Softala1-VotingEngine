package fi.softala.vote.controller;

import java.util.List;

import FormValidators.InnovationForm;
import fi.softala.vote.dao.InnoDAOJdbcImpl;
import fi.softala.vote.dao.VoterDAOJdbcImpl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import fi.softala.vote.dao.VoteDAOJdbcImpl;
import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Vote;
import fi.softala.vote.model.Voter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VoteCtrl {
	@Inject
	private VoteDAOJdbcImpl votedao;

	@Inject
	private VoterDAOJdbcImpl voterdao;

	@Inject
	private InnoDAOJdbcImpl innovationdao;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(path = "/vote", method = RequestMethod.POST)
	public String handleVote(InnovationForm innoForm, Model model, BindingResult results,
			@RequestParam(required = true) long innoId, HttpSession session) {
		Vote vote = new Vote();
		Voter voter;

		Innovation innovation = innovationdao.find(innoId);
		
		try {
			voter = (Voter) session.getAttribute("voter");

			if (voter.getTeam().equals(innovation.getTeam())) {
				results.rejectValue("error", "403",
						"You can't vote your own innovation");
				return "redirect:/innovations";
			} else if (voter.isVoted()) {
				results.rejectValue("error", "403", "You can't vote again");
				return "redirect:/login";
			}

			vote.setInnovation(innovation);
			vote.setVoter(voter);
			vote.setLegit(true);
			voter.setVoted(true);

			votedao.add(vote);
			voterdao.updateVoted(voter.getVoterId());

			//session.invalidate();
			List<Innovation> innovations = innovationdao.findAll();
			model.addAttribute("innovations", innovations);
			
			return "redirect:/results";

		} catch (Exception e) {
			return "redirect:/";
		}

	}
	
	@RequestMapping(path = "/votes", method = RequestMethod.GET)
	public String getAllVotes(InnovationForm innovationForm, Model model, HttpSession session) {
		List<Vote> votes = votedao.findAllVotes();
		List<Innovation> innos = innovationdao.findAll();
		
		for (int i = 0; i < innos.size(); i++) {
			Innovation inno = innos.get(i);
			long voteCount = 0;
			
			for (int j = 0; j < votes.size(); j++) {
				if (inno.getInnoId() == votes.get(j).getInnovation().getInnoId()) {
					voteCount++;
				}
			}
			
			inno.setVoteCount(voteCount);
		}
		
		innos.sort((obj1, obj2) -> {
			return Long.compare(obj2.getVoteCount(), obj1.getVoteCount());
		});
		
		for (int i = 0; i < innos.size(); i++) {
			System.out.println("Innovation: " + innos.get(i).getInnoName() + ", Vote count: " +
					innos.get(i).getVoteCount());
		}
		
		model.addAttribute("innovations", innos);
		session.invalidate(); //remove when returns to a results page
		
		return "redirect:/";
	}
}
