package com.ecommerce_backend.Ecommerce.Backend.Project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce_backend.Ecommerce.Backend.Project.model.User;
import com.ecommerce_backend.Ecommerce.Backend.Project.repository.UserRepository;
import com.ecommerce_backend.Ecommerce.Backend.Project.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	private User user;
	
	@BeforeEach
	void testSaveUser() {
		
		user = new User();
		user.setName("Ashish");
		user.setEmail("tcs.com");
		
		
	}
	
	@Test
	void testGetUserById_Success() {
		
		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		
		User userFound = userServiceImpl.getUserById(1L);
		
		assertEquals("Ashish", userFound.getName());
		assertEquals("tcs.com", userFound.getEmail());
		verify(userRepository, times(1)).findById(1L);
		
	}
	
	@Test
	void testGetUserById_NotFound() {
		
		when(userRepository.findById(2L)).thenReturn(Optional.empty());
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			
			userServiceImpl.getUserById(2L);
			
		});
		
		assertEquals("User not found with ID: 2", exception.getMessage());
		verify(userRepository, times(1)).findById(2L);
	}
	

}
