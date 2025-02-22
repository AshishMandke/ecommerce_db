package com.ecommerce_backend.Ecommerce.Backend.Project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce_backend.Ecommerce.Backend.Project.model.User;
import com.ecommerce_backend.Ecommerce.Backend.Project.repository.UserRepository;
import com.ecommerce_backend.Ecommerce.Backend.Project.service.impl.UserServiceImpl;

import lombok.Builder;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	private User user;

	@BeforeEach
	void setup() {

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

	@Test
	void testSaveUser() {
		
		when(userRepository.save(user)).thenReturn(user);
		
		User savedUser = userServiceImpl.saveUser(user);
		
		assertEquals("Ashish", savedUser.getName());
		assertEquals("tcs.com", savedUser.getEmail());
		verify(userRepository, times(1)).save(user);
		
	}

	@Test
	void testGetAllUsers() {

		List<User> users = List.of(

				User.builder().id(1L).email("tcs.com").password("1234").name("Ashish").role("Admin").build(),
				User.builder().id(1L).email("cap.com").password("4321").name("Ashu").role("Admin").build()

		);

		when(userRepository.findAll()).thenReturn(users);

		List<User> retrievedUsers = userServiceImpl.getAllUsers();

		assertEquals(2, retrievedUsers.size());
		assertEquals("Ashish", retrievedUsers.get(0).getName());
		verify(userRepository, times(1)).findAll();

	}

	@Test
	void testDeleteUser() {

		Long userId = 1L;

		userServiceImpl.deleteUser(userId);
		verify(userRepository, times(1)).deleteById(userId);

	}

	@Test
	void testUpdateUser() {

		Long id = 1L;

		User existingUser =  User.builder().id(1L).email("tcs.com").password("1234").name("Ashish").role("Admin").build();
		// User(1L, "tcs.com", "1234", "Ashish", "Admin");
		User updatedUser = User.builder().id(1L).email("cap.com").password("4321").name("Ashu").role("Admin").build();
		//1L, "cap.com", "4321", "Ashu", "Admin")

		when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
		
		userServiceImpl.updateUser(id, updatedUser);
		
		ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
		verify(userRepository).save(userCaptor.capture());
	
		User savedUser = userCaptor.getValue(); 
		
		assertEquals("cap.com", savedUser.getEmail());
		assertEquals("Ashu", savedUser.getName());
		

		}

}
