package fi.softala.vote.controller;

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
	public String handleVote(InnovationForm innoForm, BindingResult results,
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

			session.invalidate();

			return "redirect:/";

		} catch (Exception e) {
			return "redirect:/";
		}

	}
}
