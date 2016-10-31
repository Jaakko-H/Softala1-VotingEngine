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
import org.springframework.stereotype.Repository;

import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Vote;

@Repository
public class VoteDAOJdbcImpl implements InnovationDAO {
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
		
	public Vote addNew(Innovation inno) {
		Vote vote = new Vote();
		final String SQL = "insert into vote(voter_id, inno_id, legit) values(?, ?, ?)";
		final long VOTERID = 1;
		System.out.println("" + inno.getInnoId());
		final long INNOID = inno.getInnoId();
		final String LEGIT = "y";
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL, new String[] { "vote_id" });
				ps.setLong(1, VOTERID);
				ps.setLong(2, INNOID);
				ps.setString(3, LEGIT);
				return ps;
			}
		}, idHolder);
		
		System.out.println("" + inno.getInnoId());
		System.out.println("key:" + idHolder.getKey());
		vote.setVoteId(idHolder.getKey().longValue());
		System.out.println("" + inno.getInnoId());
		
		return vote;
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
