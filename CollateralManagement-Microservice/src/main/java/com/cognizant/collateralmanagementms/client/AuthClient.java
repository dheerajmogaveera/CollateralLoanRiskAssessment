package com.cognizant.collateralmanagementms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.collateralmanagementms.model.AuthResponse;


@FeignClient(name = "Auth",url="http://ij018pod1collateralmicroservice-env.eba-dwby7efn.us-east-2.elasticbeanstalk.com")
public interface AuthClient {
	@GetMapping(path = "/validate")
	public AuthResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);
}
