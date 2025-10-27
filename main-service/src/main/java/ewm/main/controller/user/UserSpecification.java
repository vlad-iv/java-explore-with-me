package ewm.main.controller.user;

import ewm.main.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashMap;

public class UserSpecification implements Specification<User> {
	public UserSpecification(UserParam param) {
		StringBuilder stringBuilder = new StringBuilder("select * from where 1=1");
		if (param.getParam1() != null) {
			////
			stringBuilder.append(" and param1 = :param1");
		}

		HashMap<String, Object> paramValues = new HashMap<>();
		if (param.getParam1() != null) {
			paramValues.put("param1", param.getParam1());
		}
		String sql = stringBuilder.toString();
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return null;
	}
}
