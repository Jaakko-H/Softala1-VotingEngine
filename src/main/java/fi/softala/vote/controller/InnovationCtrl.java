package fi.softala.vote.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.vote.model.Innovation;

@Controller
public class InnovationCtrl {

    @RequestMapping(path="/innovations", method=RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	
    	if(session.getAttribute("voterName") == null){
    		return "redirect:/";
    	}

    	// findAll metodin rakentaminen
    	
    	
    	/*	for (int i = 0; i < innovation.length; i++) {
			innovations.add .....
			}
    	 */	
    	
    	ArrayList <Innovation> innovations = new ArrayList<>();
    	innovations.add(new Innovation(1, "name1", "topic1"));
    	innovations.add(new Innovation(1, "name2", "topic2"));
    	innovations.add(new Innovation(1, "name3", "topic3"));
    	
    	model.addAttribute("innovations", innovations);
    	
        return "innovations";
    }

    // findOne metodin rakentaminen
    
    // voteInno metodin rakentaminen
    
    // viewVotes metodi -> ajetaan kun voteInno ajetaan, paitsi jos "superkayttaja"
}