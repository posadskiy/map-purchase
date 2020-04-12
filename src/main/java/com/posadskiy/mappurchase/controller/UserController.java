package com.posadskiy.mappurchase.controller;

import com.posadskiy.mappurchase.dto.User;

import java.util.List;

public interface UserController {
	
	List<User> getAllUsers();

	User getUserById(Integer userId);
	
	User createUser(User user);
	
}
