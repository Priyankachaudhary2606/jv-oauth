package com.jaksonauth.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.jaksonauth.dto.UserDetailsDto;



@Service
public class UserInputService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		UserDetailsDto userInfo = new UserDetailsDto(username, new BCryptPasswordEncoder().encode("jakson123"), "USER");
		System.out.print(userInfo.getUsername()+ userInfo.getPassword());
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		return new User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(authority));
	}
	


}
