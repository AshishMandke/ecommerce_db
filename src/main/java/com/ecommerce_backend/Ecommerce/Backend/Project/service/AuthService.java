package com.ecommerce_backend.Ecommerce.Backend.Project.service;

import com.ecommerce_backend.Ecommerce.Backend.Project.dto.AuthenticationRequest;
import com.ecommerce_backend.Ecommerce.Backend.Project.dto.AuthenticationResponse;
import com.ecommerce_backend.Ecommerce.Backend.Project.dto.RegisterRequest;

public interface AuthService {
	
	void registerUser(RegisterRequest request);
	AuthenticationResponse authenticateUser(AuthenticationRequest request);

}
