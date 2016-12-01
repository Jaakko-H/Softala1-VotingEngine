package fi.softala.vote.controller;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import FormValidators.InnovationForm;
import FormValidators.VoterForm;
import fi.softala.vote.dao.InnoDAOJdbcImpl;
import fi.softala.vote.dao.TeamDAOJdbcImpl;
import fi.softala.vote.dao.VoteDAOJdbcImpl;
import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Team;
import fi.softala.vote.model.Vote;

@Controller
public class AdminCtrl {
	
	@Inject
	private VoteDAOJdbcImpl votedao;
	@Inject
	private TeamDAOJdbcImpl dao;

   
    @RequestMapping(path="/admin", method=RequestMethod.GET)
    public String showAdmin(VoterForm voterForm, InnovationForm innovationForm, Model model){
    	List<Team> teams = dao.findAll();
    	teams.remove(0);
      	model.addAttribute("teams", teams);
      	
        return "admin";
    }
    
    @RequestMapping(path="/admin/login", method=RequestMethod.POST)
    public String adminAuth(){
        return "redirect:/admin";
    }
    
    @RequestMapping(path="/admin/votes", method=RequestMethod.GET)
    public String showVotes(Model model) {
    	List<Vote> votes = votedao.findAllVotes();
    	model.addAttribute("votes", votes);
    	
    	return "admin";
    }
}