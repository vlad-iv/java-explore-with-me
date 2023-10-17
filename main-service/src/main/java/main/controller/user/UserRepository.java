package main.controller.user;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import main.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@EntityGraph(value = "user-with-category")
	List<User> findByName(String name);
}
