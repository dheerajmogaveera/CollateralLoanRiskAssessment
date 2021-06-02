package com.cognizant.authenticationms.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationms.exception.InvalidCredentialsException;
import com.cognizant.authenticationms.model.Admin;
import com.cognizant.authenticationms.repository.UserRepository;


@Service

public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtil jwtutil;

	public UserDetails loadUserByUsername(String uid){
		
		Optional<Admin> user = userRepository.findById(uid);

		if(!user.isPresent()) {
			throw new InvalidCredentialsException("Either Username or Password is Wrong");
		}

		Admin custuser=user.get();
		return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
	}
	
	public String getUserName(String token) {
		return userRepository.findById(jwtutil.extractUsername(token)).orElse(null).getUname();
	}

}
