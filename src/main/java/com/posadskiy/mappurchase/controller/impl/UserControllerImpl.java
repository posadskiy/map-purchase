package com.posadskiy.mappurchase.controller.impl;

import com.posadskiy.mappurchase.controller.UserController;
import com.posadskiy.mappurchase.db.UserRepository;
import com.posadskiy.mappurchase.db.model.DbUser;
import com.posadskiy.mappurchase.dto.User;
import com.posadskiy.mappurchase.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserControllerImpl implements UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllUsers() {
		final Iterable<DbUser> all = userRepository.findAll();

		final List<User> dtoUsers = new ArrayList<>();
		all.forEach(dbUser -> dtoUsers.add(userMapper.mapToDto(dbUser)));

		return dtoUsers;
	}

	@Override
	public User getUserById(Integer userId) {
		final Optional<DbUser> byId = userRepository.findById(userId);

		return userMapper.mapToDto(
			byId.orElse(null)
		);
	}

	@Override
	public User createUser(User user) {
		return userMapper.mapToDto(
			userRepository.save(
				userMapper.mapFromDto(user)
			)
		);
	}
}
