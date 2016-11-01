package fi.softala.vote.controller;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.vote.dao.VoteDAOJdbcImpl;
import fi.softala.vote.model.Vote;

@Controller
public class AdminCtrl {
	@Inject
	private VoteDAOJdbcImpl votedao;
   
    @RequestMapping(path="/admin", method=RequestMethod.GET)
    public String showAdmin(Model model){
	
        return "admin";
    }
    
    @RequestMapping(path="/admin/votes", method=RequestMethod.GET)
    public String showVotes(Model model) {
    	List<Vote> votes = votedao.findAllVotes();
    	model.addAttribute("votes", votes);
    	
    	return "admin";
    }
}