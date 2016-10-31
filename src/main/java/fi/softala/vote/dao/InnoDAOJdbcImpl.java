package fi.softala.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.vote.model.Innovation;

@Repository
public class InnoDAOJdbcImpl {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Innovation addNew(Innovation inno) {
		final String sql = "insert into inno(team_id, inno_name, inno_desc) values(?,?,?)";

		final long innoTeamID = inno.getTeam().getTeamId();
		final String innoName = inno.getInnoName();
		final String innoDesc = inno.getInnoDesc();

		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "inno_id" });
				ps.setLong(1, innoTeamID);
				ps.setString(2, innoName);
				ps.setString(3, innoDesc);
				return ps;
			}
		}, idHolder);

		inno.setInnoId(idHolder.getKey().intValue());

		return inno;
	}

	public Innovation find(long id) {
		String sql = "select inno_name, inno_desc, inno_id, team_id from inno where inno_id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Innovation> mapper = new InnoRowMapper();

		Innovation inno;
		try {
			inno = jdbcTemplate.queryForObject(sql, parameters, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new InnoNotFoundException(e);
		}
		return inno;
	}

	public List<Innovation> findAll() {

		String sql = "select inno_id, inno_name, inno_desc, team_id from inno";
		RowMapper<Innovation> mapper = new InnoRowMapper();
		List<Innovation> innovations = jdbcTemplate.query(sql, mapper);

		return innovations;
	}
}