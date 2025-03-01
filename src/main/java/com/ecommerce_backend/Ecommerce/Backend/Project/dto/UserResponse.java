package com.ecommerce_backend.Ecommerce.Backend.Project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
	
	private Long id;
    private String name;
    private String email;
    private String role;

}
