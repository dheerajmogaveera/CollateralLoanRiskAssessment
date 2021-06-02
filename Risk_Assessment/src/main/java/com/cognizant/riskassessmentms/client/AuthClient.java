package com.cognizant.riskassessmentms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.riskassessmentms.model.AuthResponse;

@FeignClient(url = "http://ij018po1authentication-env.eba-sngkydti.us-east-2.elasticbeanstalk.com", name = "AUTH")
public interface AuthClient {

	@GetMapping(path = "/validate")
	public AuthResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
