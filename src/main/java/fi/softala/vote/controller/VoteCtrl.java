package fi.softala.vote.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.vote.model.Innovation;

@Controller
public class VoteCtrl {
	@RequestMapping(path="/vote", method=RequestMethod.POST)
	public String handleVote(@ModelAttribute() Innovation innovation, HttpSession session){
                          session.invalidate();
                          
                          return "redirect:/";
	}
}
