package com.cognizant.controllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.authenticationms.AuthenticationApplication;
import com.cognizant.authenticationms.controller.AuthController;
import com.cognizant.authenticationms.exception.InvalidCredentialsException;
import com.cognizant.authenticationms.model.Admin;
import com.cognizant.authenticationms.model.AuthResponse;
import com.cognizant.authenticationms.repository.UserRepository;
import com.cognizant.authenticationms.service.CustomerDetailsService;
import com.cognizant.authenticationms.service.JwtUtil;




@SpringBootTest(classes = {AuthenticationApplication.class})
@AutoConfigureMockMvc
public class AuthControllerTest {
	
	@InjectMocks
	AuthController authController;
	
	@Mock
	AuthResponse authResponse;
	@Mock
	UserDetails userdetails;
	
	
	
	@Mock
	JwtUtil jwtutil;
	
	@Mock
	CustomerDetailsService custdetailservice;
	
	@Mock
	UserRepository userservice;
	
	

	
	
	@Test
	void loginTest() throws InvalidCredentialsException {
		Admin admin= new Admin("raza","pass","raza",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword(), new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(admin);
		assertEquals( 200, login.getStatusCodeValue());
	}
	@Test
	void loginTest2() throws InvalidCredentialsException {
		Admin admin= new Admin("ansh","pass","ansh",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword(), new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(admin);
		assertEquals( 200, login.getStatusCodeValue());
	}

	@Test
	void loginTest3() throws InvalidCredentialsException {
		Admin admin= new Admin("dheeraj","pass","dheeraj",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword(), new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(admin);
		assertEquals( 200, login.getStatusCodeValue());
	}

	@Test
	void loginTest4() throws InvalidCredentialsException {
		Admin admin= new Admin("vamsi","pass","vamsi",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword(), new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(admin);
		assertEquals( 200, login.getStatusCodeValue());
	}


	@Test
	 void loginTestFailed() throws InvalidCredentialsException {

		Admin admin = new Admin("raza","pass","raza",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword()+"wrong", new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		assertThrows(InvalidCredentialsException.class,()-> authController.login(admin));
		
	    
	}
	@Test
	 void loginTestFailed2() throws InvalidCredentialsException {

		Admin admin = new Admin("ansh","pass","ansh",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword()+"wrong", new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		assertThrows(InvalidCredentialsException.class,()-> authController.login(admin));
		
	    
	}
	
	@Test()
	
	 void loginTestFailed3() throws InvalidCredentialsException {

		Admin admin = new Admin("dheeraj","pass","dheeraj",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword()+"wrong", new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		assertThrows(InvalidCredentialsException.class,()-> authController.login(admin));
		
	    
	}
	
	
	@Test()
	
	 void loginTestFailed4() throws InvalidCredentialsException {

		Admin admin = new Admin("vamsi","pass","vamsi",null);
		UserDetails loadUserByUsername = custdetailservice.loadUserByUsername(admin.getUserid());
		UserDetails value = new User(admin.getUserid(), admin.getUpassword()+"wrong", new ArrayList<>());
		when(custdetailservice.loadUserByUsername(admin.getUserid())).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		assertThrows(InvalidCredentialsException.class,()-> authController.login(admin));
		
	    
	}
	@Test
	 void validateTestValidtoken() {

		
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("raza");
		Admin admin = new Admin("raza","pass","raza",null);
		Optional<Admin> data = Optional.of(admin);
		when(userservice.findById("raza")).thenReturn(data);
		ResponseEntity<AuthResponse> validity = authController.getValidity("bearer token");
		assertEquals( true, validity.getBody().isValid());

	}
	@Test
	 void validateTestValidtoken2() {

		
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("ansh");
		Admin admin = new Admin("ansh","pass","ansh",null);
		Optional<Admin> data = Optional.of(admin);
		when(userservice.findById("ansh")).thenReturn(data);
		ResponseEntity<AuthResponse> validity = authController.getValidity("bearer token");
		assertEquals( true, validity.getBody().isValid());

	}

	@Test
	 void validateTestValidtoken3() {

		
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("dheeraj");
		Admin admin = new Admin("dheeraj","pass","dheeraj",null);
		Optional<Admin> data = Optional.of(admin);
		when(userservice.findById("dheeraj")).thenReturn(data);
		ResponseEntity<AuthResponse> validity = authController.getValidity("bearer token");
		assertEquals( true, validity.getBody().isValid());

	}
	@Test
	 void validateTestValidtoken4() {

		
		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("vamsi");
		Admin admin = new Admin("vamsi","pass","vamsi",null);
		Optional<Admin> data = Optional.of(admin);
		when(userservice.findById("vamsi")).thenReturn(data);
		ResponseEntity<AuthResponse> validity = authController.getValidity("bearer token");
		assertEquals( true, validity.getBody().isValid());

	}
	
	@Test
	 void validateTestInValidtoken() {

		
		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<AuthResponse> validity = authController.getValidity("bearer token");
		assertEquals( false, validity.getBody().isValid());
	}

}
