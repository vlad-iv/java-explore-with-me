package main.controller.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import main.model.User;

@Service
public class UserService {
	UserRepository userRepository;
	UserMapper userMapper;

	public List<UserDto> findBy(UserParam param, Pageable pageable) {
		Specification<User> spec = new UserSpecification(param); // часть для where на java коде
		HashMap<User, Integer> views = /// через клиента
				userMapper.toDto(users, views)
		return userRepository.findBy(spec, pageable);
	}
}
