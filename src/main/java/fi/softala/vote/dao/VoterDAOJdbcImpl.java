package fi.softala.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class VoterDAOJdbcImpl implements VoterDAO {

	@Inject
	private JdbcTemplate jdbc;

	@Inject
	private TeamDAOJdbcImpl teamdao;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbc;
	}

	public void setJdbcTemplate(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Voter findByVoterName(String fname, String sname) throws Exception {
		String query = "SELECT * FROM voter WHERE fname = ? AND sname = ?";
		Object[] params = new Object[] { fname, sname };

		return jdbc.queryForObject(query, params, (result, row) -> {
			Voter voter = new Voter();
			voter.setFirstName(result.getString("fname"));
			voter.setLastName(result.getString("sname"));
			voter.setTeam(new Team());
			voter.setType(result.getString("type"));
			voter.setVoted(result.getBoolean("voted"));
			voter.setVoterId(result.getLong("voter_id"));
			return voter;
		});

	}

	@Override
	public Voter addVoter(Voter voter) {
		String SQL = "insert into voter(fname, sname, type, team_id) values(?, ?, ?, ?)";
		final String FNAME = voter.getFirstName();
		final String SNAME = voter.getLastName();
		final String TYPE = voter.getType();
		final long TEAMID = voter.getTeam().getTeamId();

		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbc.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL,
						new String[] { "voter_id" });
				ps.setString(1, FNAME);
				ps.setString(2, SNAME);
				ps.setString(3, TYPE);
				ps.setLong(4, TEAMID);
				return ps;
			}
		}, idHolder);

		voter.setVoterId(idHolder.getKey().longValue());

		return voter;
	}

	@Override
	public Voter find(long id) {
		String query = " SELECT fname, sname, type, team_name, voted FROM voter JOIN team USING(team_id) WHERE voter_id = ?";
		Object[] params = new Object[] { id };

		return (Voter) this.jdbc.queryForObject(query, params,
				(result, row) -> {
					Voter voter = new Voter();
					voter.setFirstName(result.getString("fname"));
					voter.setLastName(result.getString("sname"));
					voter.setType(result.getString("type"));
					voter.setTeam(teamdao.findByTeamName(result
							.getString("team_name")));
					String votedString = result.getString("voted");
					if (votedString.equalsIgnoreCase("Y")) {
						voter.setVoted(true);
					} else if (votedString.equalsIgnoreCase("N")) {
						voter.setVoted(false);
					}
					return voter;
				});

	}

	@Override
	public void updateVoted(long id) {
		final String SQL = "UPDATE voter SET voted='Y' WHERE voter_id=?";
		Object[] params = new Object[] { id };
		jdbc.update(SQL, params);
	}

	
}
