package fi.softala.vote.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InnovationCtrl {

    @RequestMapping(path="/innovations", method=RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	
    	if(session.getAttribute("voterName") == null){
    		return "redirect:/";
    	}

    	// findAll metodin rakentaminen
    	
    	ArrayList<String> innovations = new ArrayList<>();
    	
    	/*	for (int i = 0; i < innovation.length; i++) {
			innovations.add .....
			}
    	 */	
    	
    	innovations.add("one");
    	innovations.add("two");
    	innovations.add("three");
    	innovations.add("four");
    	innovations.add("five");
    	
    	model.addAttribute("innovations", innovations);
    	
        return "innovations";
    }

    // findOne metodin rakentaminen
    
    // voteInno metodin rakentaminen
    
    // viewVotes metodi -> ajetaan kun voteInno ajetaan, paitsi jos "superkayttaja"
}