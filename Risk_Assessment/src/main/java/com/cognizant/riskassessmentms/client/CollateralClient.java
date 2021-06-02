package com.cognizant.riskassessmentms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.riskassessmentms.model.CollateralCashDeposit;
import com.cognizant.riskassessmentms.model.CollateralRealEstate;

@FeignClient(name = "collateral-service", url = "http://ij018po1collateralmicroservice-env.eba-5243ps3y.us-east-2.elasticbeanstalk.com")
public interface CollateralClient {

	@GetMapping("/realEstate/{loanId}")
	public ResponseEntity<CollateralRealEstate> getByIdRealEstate(@RequestHeader(name = "Authorization") String token,@PathVariable("loanId") int loanId);

	@GetMapping("cashdeposit/{loanId}")
	public ResponseEntity<CollateralCashDeposit> getByIdCashDeposit(

			@RequestHeader(name = "Authorization") String token, @PathVariable("loanId") int loanId);
	
	

}
