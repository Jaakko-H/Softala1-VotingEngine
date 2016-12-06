package fi.softala.vote.controller;

import FormValidators.InnovationForm;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.softala.vote.dao.InnoDAOJdbcImpl;
import fi.softala.vote.dao.TeamDAOJdbcImpl;
import fi.softala.vote.dao.VoterDAOJdbcImpl;
import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;

@Controller
public class InnovationCtrl {
	
	@Inject
	private TeamDAOJdbcImpl teamdao;
	
	@Inject
	private VoterDAOJdbcImpl voterdao;
	
    @Inject
    private InnoDAOJdbcImpl dao;
    public InnoDAOJdbcImpl getDao() { return dao; }
    public void setDao(InnoDAOJdbcImpl dao) { this.dao = dao; }

    @RequestMapping(path="/innovations", method=RequestMethod.GET)
    public String viewInnovations(InnovationForm innovationForm, Model model, HttpSession session) {

    	if(session.getAttribute("voter") == null){
    		return "redirect:/";
    	}
    	Voter voter = new Voter();
    	voter = (Voter) session.getAttribute("voter");
    	System.out.println("tämän äänestäjän tiimi on " + voter.getTeam());
    	
      	List<Innovation> innovations = dao.findAll();
      	for (int i = 0; i < innovations.size(); i++) {
      		if (voter.getTeam().getTeamId() == innovations.get(i).getTeam().getTeamId()) {
      			innovations.remove(i);
      		}
		}
      	model.addAttribute("innovations", innovations);
      	return "innovations";
    }
    
    @RequestMapping(path="/innovationAdd", method=RequestMethod.POST)
    public String addNew(@Valid @ModelAttribute(value="InnovationForm") InnovationForm innovationform, BindingResult result, @RequestParam("src") String src, HttpServletRequest request){
    	
    	if(result.hasErrors()){
    		return "redirect:" + src;
    	}
    	
    	Innovation innovation = new Innovation();
    	innovation.setInnoName(innovationform.getInnoName());
    	innovation.setInnoDesc(innovationform.getInnoDesc());
    	innovation.setInnoOwner(innovationform.getInnoOwner());
    	innovation.setTeam(teamdao.findByTeamName(innovationform.getTeamName()));
    	
    	try{
    		dao.addNew(innovation);
    		return "redirect:" + src;
    	}catch(Exception e){
    		result.rejectValue("error", "403", "Invalid data");
    		return "redirect:" + src;
    	}
    	
    }
}


/*
 * 
 * OPPILAS => opiskelijatunnus
 * 
 * 
 * */
