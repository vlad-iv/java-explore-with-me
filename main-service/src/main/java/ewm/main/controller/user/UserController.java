package ewm.main.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ewm.main.model.User;

@Controller
public class UserController {

	UserService userService;

	@GetMapping
	List<User> findBy(String param1, String param2, String param3, String param4, String param5, String param6) {
		return userService.findBy(param1, param2, param3, param4, param5, param6);
		UserParam param = new UserParam(param1, param2, param3, param4, param5, param6);
		Map<String, Object> params = new HashMap<>();
		params.put("param1", param1);
		// ..
		return userService.findBy(param);
	}

}
