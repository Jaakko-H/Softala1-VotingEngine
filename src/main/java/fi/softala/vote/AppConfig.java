package fi.softala.vote;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig {
	@Bean
	public BasicDataSource basicDataSource() {
		return new BasicDataSource();
	}
	@Bean
    public JdbcTemplate jdbcTemplate(BasicDataSource dataSource) {
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost/aanestys");
		dataSource.setUsername("aanestys");
		dataSource.setPassword("aani2");
		dataSource.setInitialSize(1);
		dataSource.setMaxActive(5);
        return new JdbcTemplate(dataSource);
    }
}