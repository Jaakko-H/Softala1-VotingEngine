package fi.softala.vote.dao;

import java.sql.ResultSet;

import javax.swing.tree.RowMapper;

import fi.softala.vote.model.Innovation;

public class InnoRowMapper implements RowMapper {

	public Innovation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Innovation inno = new Innovation();
		inno.setInnoId (rs.getLong("innoId"));
		inno.setInnoName (rs.getString("InnoName"));
		inno.setInnoDesc (rs.getString("InnoDesc"));
		inno.setTeamId (rs.getLong("teamId"));
		
		return inno;
	}
	
}
