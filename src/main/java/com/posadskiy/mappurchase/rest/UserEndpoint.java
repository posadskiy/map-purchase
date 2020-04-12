package com.posadskiy.mappurchase.rest;

import com.posadskiy.mappurchase.controller.UserController;
import com.posadskiy.mappurchase.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEndpoint {
	private UserController userController;

	@Autowired
	public UserEndpoint(UserController userController) {
		this.userController = userController;
	}

	@GetMapping("/")
	public List<User> getAllUsers() {
		return userController.getAllUsers();
	}

	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable("id") final Integer id) {
		return userController.getUserById(id);
	}

	@PostMapping("/")
	public User create(@RequestBody final User user) {
		return userController.createUser(user);
	}

}
