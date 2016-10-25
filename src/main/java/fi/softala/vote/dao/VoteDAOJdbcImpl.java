package fi.softala.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import fi.softala.vote.model.Innovation;

public class VoteDAOJdbcImpl implements InnovationDAO {
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
		
	public Innovation addNew(Innovation inno) {
		final String SQL = "insert into vote(voter_id, inno_id, legit) values(?, ?, ?)";
		final long VOTERID = 0;
		final long INNOID = inno.getInnoId();
		final char LEGIT = 'y';
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				
				return null;
			}
			
		});
		
		return null;
	}

	public Innovation find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Innovation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
