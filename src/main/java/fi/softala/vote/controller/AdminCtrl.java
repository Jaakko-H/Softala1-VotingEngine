package fi.softala.vote.controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminCtrl {

   
    @RequestMapping(path="/admin", method=RequestMethod.GET)
    public String showAdmin(Model model){
	
        return "admin";
    }
}