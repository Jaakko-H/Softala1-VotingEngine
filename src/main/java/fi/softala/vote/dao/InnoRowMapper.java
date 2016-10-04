package fi.softala.vote.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import fi.softala.vote.model.InnoImpl;
import fi.softala.vote.model.Innovation;

public class InnoRowMapper implements RowMapper {
	// should be as below:
	// public class InnoRowMapper implements RowMapper<Innovation> {

	public Innovation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Innovation inno = new InnoImpl();
		inno.setInnoId (rs.getLong("innoId"));
		inno.setInnoName (rs.getString("InnoName"));
		inno.setInnoDesc (rs.getString("InnoDesc"));
		inno.setTeamId (rs.getLong("teamId"));
		
		return inno;
	}

	// what's below shouldn't be, nor it's import
	
	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
