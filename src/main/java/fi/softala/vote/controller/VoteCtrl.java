package fi.softala.vote.controller;

import java.util.ArrayList;
import java.util.Collection;
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
	public String handleVote(InnovationForm innovationForm, BindingResult results, Model model, 
			@RequestParam(required = true) long innoId, HttpSession session) {
		Vote vote = new Vote();
		Voter voter;

		Innovation innovation = innovationdao.find(innoId);
		
		try {
			voter = (Voter) session.getAttribute("voter");
			System.out.println("mikä sinä olet " + innovation.getTeam() + "ja tiimi on " + voter.getTeam());
			//INNOVAATION TIIMIN ARVOKSI TULEE NULL, INNOROWMAPPER EI TOIMI
			if (voter.getTeam().getTeamId() == innovation.getTeam().getTeamId()) {
				results.rejectValue("error", "403","You can't vote your own innovation");
				return "redirect:/innovations";
			} else if (voter.isVoted()) {
				results.rejectValue("error", "403", "You can't vote the same again");
				log.info("you have already voted");
				session.invalidate();
				return "redirect:/login";
			}

			vote.setInnovation(innovation);
			vote.setVoter(voter);
			vote.setLegit(true);
			voter.setVoted(true);

			votedao.add(vote);
			voterdao.updateVoted(voter.getVoterId());

			session.invalidate();
			
			List<Innovation> innovations = innovationdao.findAll();
	
			// set vote count 
			for( Innovation inno : innovations){
				inno.setVoteCount(votedao.findByInnovation(inno).size());
			}
			
			innovations.sort((obj1, obj2) -> {
				return Long.compare(obj2.getVoteCount(), obj1.getVoteCount());
			});
			
			List<Vote> votec = votedao.findAllVotes();
			int allvotes = 0;
			
			for (int o = 1; o < votec.size(); o++) {
				System.out.println(votec.get(o));
					allvotes = o;
			}
			allvotes = votec.size();
			System.out.println(allvotes + " annetut ��net yhteens�");
			
			model.addAttribute("innovations", innovations);
			model.addAttribute("allvotes", allvotes);
			return "results";

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}

	}
}
