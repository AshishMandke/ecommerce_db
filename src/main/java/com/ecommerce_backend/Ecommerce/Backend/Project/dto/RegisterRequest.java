package com.ecommerce_backend.Ecommerce.Backend.Project.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
	private String email;
	private String password;
	private String name;
	private String role;

}
