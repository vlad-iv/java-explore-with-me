package ewm.main.controller.user;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping
	public List<UserDto> findBy(
			@RequestParam String param1,
			@RequestParam String param3,
			@RequestParam String param4,
			@RequestParam String param5,
			Pageable pageable
	) {

		log.info("Find By param admin");
		AdminUserParam param = new AdminUserParam();
		param.setParam1(param1);
		param.setParam3(param3);
		param.setParam4(param4);
		param.setParam5(param5);
		return userService.findBy(param, pageable);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto createUser(@RequestBody UserDto userDto) {
		log.info("Creating user {}", userDto);
		return userService.createUser(userDto);
	}
}
