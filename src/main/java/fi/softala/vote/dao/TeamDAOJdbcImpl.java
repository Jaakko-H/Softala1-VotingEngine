package fi.softala.vote.dao;

import java.util.List;
import fi.softala.vote.model.Team;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAOJdbcImpl implements TeamDAO {

	@Inject
	private JdbcTemplate jdbc;

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbc;
	}

	public void setJdbcTemplate(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Team find(long id) {

		String query = "SELECT * FROM team WHERE team_id = ?";
		Object[] params = new Object[] { id };
		return this.jdbc.queryForObject(query, params, (result, row) -> {
			Team team = new Team();
			team.setTeamId(result.getLong("team_id"));
			team.setTeamName(result.getString("team_name"));
			return team;
		});

	}

	@Override
	public Team findByTeamName(String teamName) {
		String query = "SELECT * FROM team WHERE team_name = ?";
		Object[] params = new Object[] { teamName };
		return this.jdbc.queryForObject(query, params, (result, row) -> {
			Team team = new Team();
			team.setTeamId(result.getLong("team_id"));
			team.setTeamName(result.getString("team_name"));
			return team;
		});
	}

	@Override
	public List<Team> findAll() {
		String query = "SELECT team_id, team_name FROM team";
		return this.jdbc.query(query, (result, row) -> {
			Team team = new Team();
			team.setTeamId(result.getLong("team_id"));
			team.setTeamName(result.getString("team_name"));
			return team;
		});
	}

}
