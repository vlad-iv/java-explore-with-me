package main.controller.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class AdminUserController {
	private final UserService userService;

	@GetMapping
	public List<UserDto> getAllUsers() {
		log.info("Get all users");
		return userService.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto createUser(@RequestBody UserDto userDto) {
		log.info("Creating user {}", userDto);
		return userService.createUser(userDto);
	}
}
