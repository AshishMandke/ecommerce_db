package com.ecommerce_backend.Ecommerce.Backend.Project.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce_backend.Ecommerce.Backend.Project.model.User;

public interface UserService {
	
	User saveUser(User user);
	User getUserById(Long Id);
	List<User> getAllUsers();
	void deleteUser(Long id);
	User updateUser(Long id, User updatedUser);
	
	
}
