package com.ecommerce_backend.Ecommerce.Backend.Project.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce_backend.Ecommerce.Backend.Project.dto.AuthenticationRequest;
import com.ecommerce_backend.Ecommerce.Backend.Project.dto.AuthenticationResponse;
import com.ecommerce_backend.Ecommerce.Backend.Project.dto.RegisterRequest;
import com.ecommerce_backend.Ecommerce.Backend.Project.model.User;
import com.ecommerce_backend.Ecommerce.Backend.Project.security.JwtUtil;
import com.ecommerce_backend.Ecommerce.Backend.Project.service.AuthService;
import com.ecommerce_backend.Ecommerce.Backend.Project.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final JwtUtil jwtUtil;

	@Override
	public void registerUser(RegisterRequest request) {
		
		if(userService.getUserByEmail(request.getEmail()).isPresent()) {
			
			throw new RuntimeException("Email already in use. Please use a different email");
			
		}
		
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		
		 User user = User.builder()
	                .name(request.getName())
	                .email(request.getEmail())
	                .password(encodedPassword)
	                .role(request.getRole())
	                .build();
		 
		 userService.saveUser(user);
		
	}

	@Override
	public AuthenticationResponse authenticateUser(AuthenticationRequest request) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		
		String token = jwtUtil.generateToken(request.getEmail(), userDetails.getAuthorities().stream()
				.map(grantedAuthority -> grantedAuthority.getAuthority())
				.toList()
				);
				
		return AuthenticationResponse.builder().token(token).build();
	}
	
	

}
