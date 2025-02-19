package com.ecommerce_backend.Ecommerce.Backend.Project.service.impl;

import java.util.List;
import java.util.Optional;

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
		userRepository.save(user);
		return null;
	}

	@Override
	public User getUserById(Long id) {
	    return userRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

}
