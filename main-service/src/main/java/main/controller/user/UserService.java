package main.controller.user;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
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
		Page<User> page = userRepository.findAll(spec, pageable);
		HashMap<User, Integer> views = new HashMap<>(); /// через клиента
		List<UserDto> dto = userMapper.toDto(page.getContent(), views);
		return dto;
	}

	public List<UserDto> getAll() {
		return null;
	}

	public UserDto createUser(UserDto userDto) {
		return userDto;
	}

	@Transactional
	public UserDto updateUser(UserDto userDto) {
		User user = userRepository.findBy(userDto.getId()).orElseThrow();
		user.setCategory(categoryRepository.findBy(userDto.CategoryId()).orElseThrow());
//		userRepository.save(user); // Optional
		userRepository.findBy(userDto.getId()).orElseThrow();

		User user = userMapper.toEntity(userDto);
		userRepository.save(user); // Must
		return userDto;
	}
}
