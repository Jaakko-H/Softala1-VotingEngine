package fi.softala.vote.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.vote.dao.InnoDAOHibernateImpl;
import fi.softala.vote.dao.InnovationDAO;
import fi.softala.vote.model.Innovation;

@Controller
@RequestMapping (value="/innovation")
public class InnovationCtrl {
	
    @Inject
    @Qualifier("hibernate")    
	private InnoDAOHibernateImpl hibernateDAO;

	
    @Bean
	public InnoDAOHibernateImpl getDao() {
		return hibernateDAO;
	}

	public void setDao(InnoDAOHibernateImpl hibernateDAO) {
		this.hibernateDAO= hibernateDAO;
	}

    @RequestMapping(path="/index", method=RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	
    	
    	
    	
    	if(session.getAttribute("voterName") == null){
    		return "redirect:/";
    	}
    	// findAll metodin rakentaminen
    	
      		List<Innovation> innovations = hibernateDAO.findAll();
      		model.addAttribute("innovations", innovations);
      		return "innovations";
    	
    	
    	/*	for (int i = 0; i < innovation.length; i++) {
			innovations.add .....
			}
    	 */	
    	
//    	ArrayList <Innovation> innovations = new ArrayList<>();
//    	innovations.add(new Innovation(1, "name1", "topic1"));
//    	innovations.add(new Innovation(1, "name2", "topic2"));
//    	innovations.add(new Innovation(1, "name3", "topic3"));
//    	
//    	model.addAttribute("innovations", innovations);
    	
      //  return "innovations";
    }
  

    // findOne metodin rakentaminen
    
    // voteInno metodin rakentaminen
    
    // viewVotes metodi -> ajetaan kun voteInno ajetaan, paitsi jos "superkayttaja"
}