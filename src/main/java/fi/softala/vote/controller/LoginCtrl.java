package fi.softala.vote.controller;

import FormValidators.LoginForm;
import fi.softala.vote.dao.TeamDAOJdbcImpl;
import fi.softala.vote.dao.VoterDAOJdbcImpl;
import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginCtrl {

	@Inject
	private VoterDAOJdbcImpl voterdao;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Inject
	private TeamDAOJdbcImpl dao;
	

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String viewLogin(LoginForm loginForm, Model model) {
		 
		List<Team> teams = dao.findAll();
		teams.remove(0);
	  	model.addAttribute("teams", teams);
	  	System.out.print(teams);
	  	
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String handleLogin(@Valid LoginForm loginForm, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "login";
		}
		
		Voter voter;
		if (loginForm.getTeamName() != null) {
			try {
				voter = voterdao.findByVoterTeam(loginForm.getVoterFirstName(), loginForm.getVoterSirName(), loginForm.getTeamName());
				System.out.println(loginForm.getTeamName());
				session.setAttribute("voter", voter);
				System.out.print(voter);
				return "redirect:/innovations";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			voter = voterdao.findByVoterName(loginForm.getVoterFirstName(),
					loginForm.getVoterSirName());
			
			
			session.setAttribute("voter", voter);
			System.out.print(voter);
			return "redirect:/innovations";
		} catch (Exception e) {
			result.rejectValue("voterFirstName", "403",
					"You are not invited to vote");
			System.out.println("No Vote");
			return "login";
		}
	}
}
