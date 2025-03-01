package com.ecommerce_backend.Ecommerce.Backend.Project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ecommerce_backend.Ecommerce.Backend.Project.dto.UserResponse;
import com.ecommerce_backend.Ecommerce.Backend.Project.model.User;
import com.ecommerce_backend.Ecommerce.Backend.Project.repository.UserRepository;
import com.ecommerce_backend.Ecommerce.Backend.Project.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository userRepository;
	
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public UserResponse getUserById(Long id) {
		
	    User user = userRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	     
	     return UserResponse.builder()
	    		 .id(user.getId())
	    		 .email(user.getEmail())
	    		 .name(user.getName())
	    		 .role(user.getRole())
	    		 .build();
	     
	}
	
	@Override
	public Optional<User> getUserByEmail(String email) {
	    return userRepository.findByEmail(email);
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

	@Override
	public User updateUser(Long id, User updatedUser) {
		// TODO Auto-generated method stub 	
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
		
		BeanUtils.copyProperties(updatedUser, existingUser, "id");
		
		return userRepository.save(existingUser);
	}
	

}
