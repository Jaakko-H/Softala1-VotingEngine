package fi.softala.vote.controller;

import FormValidators.InnovationForm;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.softala.vote.dao.InnoDAOJdbcImpl;
import fi.softala.vote.dao.TeamDAOJdbcImpl;
import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Team;

@Controller
public class InnovationCtrl {
	
	 @Inject
	 private TeamDAOJdbcImpl teamdao;
	
    @Inject
    private InnoDAOJdbcImpl dao;
    public InnoDAOJdbcImpl getDao() { return dao; }
    public void setDao(InnoDAOJdbcImpl dao) { this.dao = dao; }

    @RequestMapping(path="/innovations", method=RequestMethod.GET)
    public String viewInnovations(InnovationForm innovationForm, Model model, HttpSession session) {

    	if(session.getAttribute("voter") == null){
    		return "redirect:/";
    	}

      	List<Innovation> innovations = dao.findAll();
      	model.addAttribute("innovations", innovations);
      	return "innovations";
    }
    
    @RequestMapping(path="/innovationAdd", method=RequestMethod.POST)
    public String addNew(
    		@ModelAttribute(value="InnovationForm") InnovationForm innovationform){
    	Innovation inno = new Innovation();
    	inno.setInnoName(innovationform.getInnoName());
    	Team team = new Team();
    	team.setTeamName(innovationform.getTeamName());
    	inno.setTeam(team);
    	inno.setInnoDesc(innovationform.getInnoDesc());
    	inno.setInnoOwner(innovationform.getInnoOwner());
    	
    	List<Team> teams = teamdao.findAll();
    	for (int i =0; i< teams.size();i++) {
    		if (team.getTeamName().equalsIgnoreCase(teams.get(i).getTeamName())) {
    			team.setTeamId(teams.get(i).getTeamId());
    		}
    	}

    	dao.addNew(inno);
    	
		return "admin";
    }
}


/*
 * 
 * OPPILAS => opiskelijatunnus
 * 
 * 
 * */
