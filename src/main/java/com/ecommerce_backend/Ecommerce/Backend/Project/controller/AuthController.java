package com.ecommerce_backend.Ecommerce.Backend.Project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce_backend.Ecommerce.Backend.Project.dto.AuthenticationRequest;
import com.ecommerce_backend.Ecommerce.Backend.Project.dto.AuthenticationResponse;
import com.ecommerce_backend.Ecommerce.Backend.Project.dto.RegisterRequest;
import com.ecommerce_backend.Ecommerce.Backend.Project.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
		
		authService.registerUser(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully!");
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
		
		AuthenticationResponse response = authService.authenticateUser(request);
		
		return ResponseEntity.ok(response);
	}
	

}
