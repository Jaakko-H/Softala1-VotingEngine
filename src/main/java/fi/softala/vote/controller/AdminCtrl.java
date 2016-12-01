package fi.softala.vote.controller;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.vote.dao.InnoDAOJdbcImpl;
import fi.softala.vote.dao.TeamDAOJdbcImpl;
import fi.softala.vote.dao.VoteDAOJdbcImpl;
import fi.softala.vote.dao.VoterDAO;
import fi.softala.vote.dao.VoterDAOJdbcImpl;
import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Team;
import fi.softala.vote.model.Vote;
import fi.softala.vote.model.Voter;

@Controller
public class AdminCtrl {
	
	@Inject
	private VoteDAOJdbcImpl votedao;
	@Inject
	private VoterDAOJdbcImpl voterdao;
	@Inject
	private TeamDAOJdbcImpl teamdao;
	@Inject
	private InnoDAOJdbcImpl innodao;

   
    @RequestMapping(path="/admin", method=RequestMethod.GET)
    public String showAdmin(Model model){
	
    	List<Team> teams = teamdao.findAll();
    	List<Innovation> innovations = innodao.findAll();
    	List<Voter> voters = voterdao.findAll();
    	
    	teams.remove(0);
      	model.addAttribute("teams", teams);
      	model.addAttribute("innovations", innovations);
      	model.addAttribute("voters", voters);
      	
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