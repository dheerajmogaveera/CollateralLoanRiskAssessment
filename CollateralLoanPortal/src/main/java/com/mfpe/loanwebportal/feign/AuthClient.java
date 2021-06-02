package com.mfpe.loanwebportal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mfpe.loanwebportal.modelvo.Admin;

@FeignClient(name="AUTHENTICATION", url="http://ij018po1authentication-env.eba-sngkydti.us-east-2.elasticbeanstalk.com")
public interface AuthClient {
	
	@PostMapping("/login")
	public ResponseEntity<Admin> login(@RequestBody Admin admin);
	
}
