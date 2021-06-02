package com.cognizant.riskassessmentms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.riskassessmentms.model.CustomerLoan;

@Component
@FeignClient(name = "loan-service", url = "http://ij018po1loanmicroservice-env.eba-apmsmukx.us-east-2.elasticbeanstalk.com")
public interface CustomerLoanClient {

	@GetMapping(path = "loan/{loanId}")
	public ResponseEntity<CustomerLoan> getById(@PathVariable("loanId") int loanId
			,@RequestHeader(name = "Authorization") String token);

}
