package com.ecommerce_backend.Ecommerce.Backend.Project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce_backend.Ecommerce.Backend.Project.model.User;
import com.ecommerce_backend.Ecommerce.Backend.Project.repository.UserRepository;
import com.ecommerce_backend.Ecommerce.Backend.Project.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserById(Long Id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

}
