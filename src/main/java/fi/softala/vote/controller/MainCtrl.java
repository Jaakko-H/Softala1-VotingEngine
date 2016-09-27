package fi.softala.vote.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainCtrl {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showLogin(HttpSession session){
		
		if(session.getAttribute("voterName") != null){
			return "redirect:/innovations";
		}
		
		return "login";
	}
	
}
