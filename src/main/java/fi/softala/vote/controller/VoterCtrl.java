package fi.softala.vote.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.vote.dao.VoterDAOJdbcImpl;
import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;

@Controller
public class VoterCtrl {
	@Inject
    private VoterDAOJdbcImpl dao;
	
    public VoterDAOJdbcImpl getDao() { return dao; }
    
    public void setDao(VoterDAOJdbcImpl dao) { this.dao = dao; }
    
    @RequestMapping(path="/addVoter", method=RequestMethod.POST)
    public String addNewVoter(Model model, HttpSession session) {
    	Voter voter = new Voter();
    	voter.setFirstName("fname");
    	voter.setLastName("sname");
    	voter.setType("vType");
    	Team team = new Team();
    	team.setTeamId(1);
    	voter.setTeam(team);
    	
    	dao.addVoter(voter);
    	
    	return "redirect:/";
    }
}
