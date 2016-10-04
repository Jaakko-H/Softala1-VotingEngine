package fi.softala.vote.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Innovation;

public class InnoRowMapper implements RowMapper<Innovation> {
	
	public Innovation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Innovation inno = new Innovation();
		inno.setInnoId (rs.getLong("innoId"));
		inno.setInnoName (rs.getString("InnoName"));
		inno.setInnoDesc (rs.getString("InnoDesc"));
		inno.setTeamId (rs.getLong("teamId"));
		
		return inno;
	}
}
