package fi.softala.innovation;

import java.util.ArrayList;
import java.util.List;

import fi.softala.vote.dao.InnovationDAO;
import fi.softala.vote.model.*;

public class MockInnovationDAO implements InnovationDAO {
	public Innovation find() {
		return new Innovation();
	}
	
	public List<Innovation>	findAll(){
		List <Innovation> innovations = new ArrayList<Innovation>();
		Innovation innovation = new Innovation();
		innovation.innoid=1;
		innovation.innoname="Virtual glasses";
		innovation.innodesc="Virtuality";
		innovations.add(innovation);
		return innovations;
	}
}
