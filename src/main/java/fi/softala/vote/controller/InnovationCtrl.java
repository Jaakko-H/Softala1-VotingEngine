package fi.softala.vote.controller;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fi.softala.vote.dao.InnoDAOJdbcImpl;
import fi.softala.vote.model.Innovation;

@Controller
public class InnovationCtrl {
	
    @Inject
    private InnoDAOJdbcImpl dao;
    public InnoDAOJdbcImpl getDao() { return dao; }
    public void setDao(InnoDAOJdbcImpl dao) { this.dao = dao; }

    @RequestMapping(path="/innovations", method=RequestMethod.GET)
    public String index(Model model, HttpSession session) {

    	if(session.getAttribute("voter") == null){
    		return "redirect:/";
    	}

      	List<Innovation> innovations = dao.findAll();
      	model.addAttribute("innovations", innovations);
      	return "innovations";
    }
}
