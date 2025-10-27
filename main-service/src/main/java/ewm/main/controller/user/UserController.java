package ewm.main.controller.user;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

	UserService userService;

	@GetMapping
    List<UserDto> findBy(String param1, String param2, String param3, String param4, String param5, String param6, Pageable pageable) {
//		return userService.findBy(param1, param2, param3, param4, param5, param6);
        UserParam param = new UserParam(param1, param2, param3, param4, param5, param6, pageable);
//		Map<String, Object> params = new HashMap<>();
//		params.put("param1", param1);
//		// ..
		return userService.findBy(param);
	}

}
