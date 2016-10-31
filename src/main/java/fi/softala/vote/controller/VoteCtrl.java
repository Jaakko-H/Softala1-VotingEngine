package fi.softala.vote.controller;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import fi.softala.vote.dao.VoteDAOJdbcImpl;
import fi.softala.vote.model.Innovation;

@Controller
public class VoteCtrl {
	@Inject
	private VoteDAOJdbcImpl dao;
	
	public VoteDAOJdbcImpl getDao() {
		return dao;
	}

	public void setDao(VoteDAOJdbcImpl dao) {
		this.dao = dao;
	}
	
	public String handleVote(@RequestParam(required=true) String innoId, HttpSession session){
		Innovation inno = new Innovation();
		inno.setInnoId(Long.parseLong(innoId));
		dao.addNew(inno);
		
		session.invalidate();
		return "redirect:/";
	}
}
