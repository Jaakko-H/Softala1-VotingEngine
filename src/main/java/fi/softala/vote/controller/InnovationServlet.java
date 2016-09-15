package fi.softala.vote.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.softala.innovation.InnovationDaoJDBCSpringimplTest;
import fi.softala.vote.dao.DaoInnovation;
import fi.softala.vote.model.Innovation;


/**
 * Servlet implementation class KelloServlet
 */
@WebServlet("/InnovationServlet")
public class InnovationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InnovationServlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoInnovation dao=new InnovationDaoJDBCSpringimplTest();
		List<Innovation> innovations=dao.getInnovations();
		
		for(int i=0; i<innovations.size(); i++){
			Innovation inno=innovations.get(i);
			System.out.println("Nimi"+inno.name);
		}
		System.out.println("Nimi");
	}
}
