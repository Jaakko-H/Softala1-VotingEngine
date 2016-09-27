package fi.softala.vote.dao;

import java.util.List;

import fi.softala.vote.model.Innovation;

public interface InnovationDAO {
	Innovation find();
	List<Innovation> findAll();
}
