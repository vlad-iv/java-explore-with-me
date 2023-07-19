package controller.user;

import org.springframework.data.jpa.domain.Specification;

import model.User;

public class UserSpecification implements Specification<User> {
	public UserSpecification(UserParam param) {
		StringBuilder stringBuilder = new StringBuilder();
		if (param.getParam1() != null) {
			////
			stringBuilder.append(" param1 = ?");
		}

		if (param.getParam1() != null) {
			sql.add(param.getParam1());
		}
	}
}
