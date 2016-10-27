package fi.softala.vote.controller;

import FormValidators.LoginForm;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCtrl {
    
                @RequestMapping(path="/login", method=RequestMethod.GET)
                public String viewLogin(LoginForm loginForm){
                    return "login";
                }

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String handleLogin(@Valid LoginForm loginForm,  BindingResult result, HttpSession session){
                          if(result.hasErrors()){ return "login"; }
                          /*
                            1. FIND VOTER HERE WITH loginForm.getVoterName();
                            2. IF FOUND => STORE TO SESSION AND CONTINUE TO INNOVATIONS
                          */
                          session.setAttribute("voterName", loginForm.getVoterName());
                          return "redirect:/innovations";
	}
}
