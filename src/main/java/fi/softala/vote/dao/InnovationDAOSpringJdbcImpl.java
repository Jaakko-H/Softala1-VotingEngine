package fi.softala.vote.dao;

import java.util.ArrayList;
import java.util.List;

import fi.softala.vote.model.Innovation;

public class InnovationDAOSpringJdbcImpl {
	public Innovation find() {
		return new Innovation();
	}
	
	public List<Innovation> findAll() {
		return new ArrayList<Innovation>();
	}
}
