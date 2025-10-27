package ewm.main.controller.user;

import ewm.main.event.EventRepository;
import ewm.main.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    EventRepository eventRepository;
    UserMapper userMapper;

    public List<UserDto> findBy(UserParam param) {
        Specification<User> spec = new UserSpecification(param); // часть для where на java коде
        Page<User> page = userRepository.findAll(spec, param.getPageable());
        HashMap<User, Integer> views = new HashMap<>(); /// через клиента
        List<UserDto> dto = userMapper.toDto(page.getContent(), views);
        return dto;
    }

    public List<UserDto> findBy(AdminUserParam param, Pageable pageable) {
        Page<User> page = userRepository.findAll(/*param, */pageable);
        HashMap<User, Integer> views = new HashMap<>(); /// через клиента
        List<UserDto> dto = userMapper.toDto(page.getContent(), views);
        return dto;
    }

    @Transactional()
    public List<UserDto> getAll() {
        return null;
    }

    public UserDto createUser(UserDto userDto) {
        return userDto;
    }

    @Transactional
    public UserDto updateUser(UserDto userDto) {
        User user = getUser(userDto);
//		user.setCategory(categoryRepository.findBy(userDto.CategoryId()).orElseThrow());
//		userRepository.save(user); // Optional
//		userRepository.findBy(userDto.getId()).orElseThrow();

//		User user = userMapper.toEntity(userDto);
//		userRepository.save(user); // Must
        return userDto;
    }

    private User getUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow();
        return user;
    }
}
