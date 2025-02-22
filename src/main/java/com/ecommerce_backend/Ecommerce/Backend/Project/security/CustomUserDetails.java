package com.ecommerce_backend.Ecommerce.Backend.Project.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce_backend.Ecommerce.Backend.Project.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		
		return user.isEnabled();
	}
	
	


}
