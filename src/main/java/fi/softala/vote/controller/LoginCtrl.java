package fi.softala.vote.controller;

import FormValidators.LoginForm;
import fi.softala.vote.dao.VoterDAOJdbcImpl;
import fi.softala.vote.model.Voter;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginCtrl {
    
    
                  private VoterDAOJdbcImpl voterdao;
    
                @RequestMapping(path="/login", method=RequestMethod.GET)
                public String viewLogin(LoginForm loginForm){
                    return "login";
                }

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String handleLogin(@Valid LoginForm loginForm,  BindingResult result, HttpSession session){
                          if(result.hasErrors()){ return "login"; }
                          Voter voter = null;
                          try {
                            voter = (Voter) voterdao.findByVoterName(loginForm.getVoterName());
                            session.setAttribute("voter", voter);
                            return "redirect:/innovations";
                          } catch (NullPointerException e){
                             result.rejectValue("voterName", "403", "You are not invited to vote");
                             return "login";
                          }      
	}
}
