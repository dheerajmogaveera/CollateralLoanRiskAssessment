package com.cognizant.loanmanagementms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.loanmanagementms.model.AuthResponse;


@FeignClient(/*"COLLATERAL-MANAGEMENT-SERVICE"*/name = "Auth",url="http://localhost:8082")
public interface AuthClient {
	@GetMapping(path = "/validate")
	public AuthResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);
}
