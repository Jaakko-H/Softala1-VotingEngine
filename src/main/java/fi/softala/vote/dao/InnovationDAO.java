package fi.softala.vote.dao;

import java.util.List;

import fi.softala.vote.model.Innovation;

public interface InnovationDAO {
	
	public abstract void addNew (Innovation inno);
	
	public abstract Innovation find(long id);

	public abstract List<Innovation> findAll();
}
