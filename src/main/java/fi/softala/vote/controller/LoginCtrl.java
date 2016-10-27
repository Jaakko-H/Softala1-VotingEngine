package fi.softala.vote.controller;

import javax.servlet.http.HttpSession;

//import org.assertj.core.util.Compatibility.System;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginCtrl {

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String handleLogin(@RequestParam(required=true) String voterName, HttpSession session){
		
		if(voterName.isEmpty() || voterName == null){
			return "redirect:/";
		}
		
		session.setAttribute("voterName", voterName);
		String str = voterName;
		
		boolean retval = str.contains(" ");
		if (retval) {
			
		
		String[] splitStr = str.split("\\s+");
		
		
		for (int i=0;i < splitStr.length; i++) {
			System.out.println(splitStr[i]);
		}
		} else {
			System.out.println("no space");
		}
		return "redirect:innovation/index";
	}
	
}
