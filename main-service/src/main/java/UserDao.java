import java.util.Map;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import main.model.User;

@Repository
public class UserDao {
	JdbcOperations template;
	NamedParameterJdbcOperations namedParameterJdbcOperations;

	public UserDao(NamedParameterJdbcOperations template) {
		this.namedParameterJdbcOperations = namedParameterJdbcOperations;
		this.template = namedParameterJdbcOperations.getJdbcOperations();
	}

	User getById(long id) {
		return template.query("select * from users where id = ?", new RowMapper<User>(), id);
		// spring-data-jdbc

	}

	User getById(long id) {
		return namedParameterJdbcOperations.query("select * from users where id = :id", Map.of("id", id), new RowMapper<User>());
		// spring-data-jdbc

	}
}
