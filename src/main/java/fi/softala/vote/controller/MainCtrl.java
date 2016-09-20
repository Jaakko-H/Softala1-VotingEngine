package fi.softala.vote.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCtrl {

    @RequestMapping("/")
    public String index(Model model) {
    	
    	ArrayList<String> innovations = new ArrayList<>();
    	
    	innovations.add("one");
    	innovations.add("two");
    	innovations.add("three");
    	innovations.add("four");
    	innovations.add("five");
    	
    	model.addAttribute("innovations", innovations);
    	
        return "innovations";
    }

}