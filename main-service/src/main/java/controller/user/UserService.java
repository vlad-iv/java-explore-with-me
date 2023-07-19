package controller.user;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserService {
	UserRepository userRepository;

	public List<User> findBy(UserParam param, Pageable pageable) {
		Specification<User> spec = new UserSpecification(param); // часть для where на java коде
		return userRepository.findBy(spec, pageable);
	}
}
