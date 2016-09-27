package fi.softala.vote.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainCtrl {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showLogin(HttpSession session, Model model){
		
		if(session.getAttribute("voterName") != null){
			return "redirect:/innovations";
		}
		ArrayList <String> innovations = new ArrayList<>();
    	innovations.add("one");
    	innovations.add("two");
    	innovations.add("three");
    	innovations.add("four");
    	innovations.add("five");
    	
    	model.addAttribute("innovations", innovations);
    	
        return "login";
    }

    // findOne metodin rakentaminen
    
    // voteInno metodin rakentaminen
    
    // viewVotes metodi -> ajetaan kun voteInno ajetaan, paitsi jos "superk�ytt�j�"
}