package com.ecommerce_backend.Ecommerce.Backend.Project.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
	
	private String secret;
	
	
}
