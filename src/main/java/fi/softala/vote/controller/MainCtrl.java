package fi.softala.vote.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCtrl {

    @RequestMapping("/")
    public String index(Model model) {
    	
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
    	
        return "login";
    }

    // findOne metodin rakentaminen
    
    // voteInno metodin rakentaminen
    
    // viewVotes metodi -> ajetaan kun voteInno ajetaan, paitsi jos "superk�ytt�j�"
}