package com.cognizant.authenticationms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationms.exception.InvalidCredentialsException;
import com.cognizant.authenticationms.model.Admin;
import com.cognizant.authenticationms.model.AuthResponse;
import com.cognizant.authenticationms.service.CustomerDetailsService;
import com.cognizant.authenticationms.service.JwtUtil;




@RestController

public class AuthController {


	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService custdetailservice;

	
	
	@PostMapping(value = "/login")
	public ResponseEntity<Admin> login(@RequestBody Admin userlogincredentials)  {
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUserid());
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			return new ResponseEntity<Admin>(
					new Admin(userlogincredentials.getUserid(), null, null, jwtutil.generateToken(userdetails)),
					HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Either Username or Password is Wrong"); 
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	
	
	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token) {
		
		String actualToken=token.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(actualToken)) {
			res.setUid(jwtutil.extractUsername(actualToken));
			res.setValid(true);
			res.setName(custdetailservice.getUserName(actualToken));

		} else
			res.setValid(false);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}