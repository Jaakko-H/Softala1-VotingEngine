package fi.softala.vote.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import FormValidators.VoterForm;
import fi.softala.vote.dao.TeamDAOJdbcImpl;
import fi.softala.vote.dao.VoterDAOJdbcImpl;
import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;

@Controller
public class VoterCtrl {
	@Inject
    private TeamDAOJdbcImpl teamdao;
	
	@Inject
    private VoterDAOJdbcImpl voterdao;
	
    public VoterDAOJdbcImpl getDao() { return voterdao; }
    
    public void setDao(VoterDAOJdbcImpl voterdao) { this.voterdao = voterdao; }
    
    @RequestMapping(path="/addVoter", method=RequestMethod.POST)
    public String addNewVoter(@Valid VoterForm voterForm, BindingResult result, HttpSession session) {
    	 System.out.println(result);
    	if (result.hasErrors()) {
    		result.rejectValue("fName", "403",
					"You are not invited to vote");
			return "redirect:/admin";
		}
    	Voter voterToAdd = new Voter();
    	List<Team> teams = teamdao.findAll();
    	List<Voter> voters = voterdao.findAll();
    	
    	voterToAdd.setFirstName(voterForm.getfName());
    	voterToAdd.setLastName(voterForm.getsName());
    	voterToAdd.setType(voterForm.getvType());
    	
    	Team team = new Team();
		boolean found = false;
		
		for (int i = 0; i < voters.size(); i++) {
			Voter voter = voters.get(i);
			
			if (voterToAdd.getFirstName().equals(voter.getFirstName()) &&
					voterToAdd.getLastName().equals(voter.getLastName())) {
				if (voter.getTeam().getTeamId() != 9999) {
					System.out.println("" + voterToAdd.getFirstName() + " " + voterToAdd.getLastName() +
							" is already a member of a team.");
				}
				else {
					voterdao.updateTeam(voter, team);
					System.out.println("Updated team of " + voter.getFirstName() + " " + voter.getLastName());
				}
				found = true;
				break;
			}
		}
		
		if (!found) {
			voterdao.addVoter(voterToAdd);
		}
    	
//    	if (voter.getType().equals("INNOMEM")){
//    		team = teamdao.findByTeamName(voterForm.gettName());
//    		voter.setTeam(team);
//    	} 
//    	else {
//	    	team.setTeamId(1);
//	    	voter.setTeam(team);
//    	}
    
    	return "redirect:/admin";
    }
}
