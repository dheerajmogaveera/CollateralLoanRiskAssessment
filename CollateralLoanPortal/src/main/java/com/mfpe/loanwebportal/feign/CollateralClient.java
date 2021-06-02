package com.mfpe.loanwebportal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.loanwebportal.modelvo.CollateralCashDepositsVO;
import com.mfpe.loanwebportal.modelvo.CollateralRealEsatateVO;

@FeignClient(/*"COLLATERAL-MANAGEMENT-SERVICE"*/name = "COLLATERAL-MS", url="http://ij018po1collateralmicroservice-env.eba-5243ps3y.us-east-2.elasticbeanstalk.com")
public interface CollateralClient {
	@GetMapping("/realEstate/{loanId}")
	public ResponseEntity<CollateralRealEsatateVO> getByIdRealEstate(@RequestHeader(name = "Authorization") String token,@PathVariable("loanId") int loanId);
	

	@GetMapping("/cashdeposit/{loanId}")
	public ResponseEntity<CollateralCashDepositsVO> getByIdCashDeposit(@RequestHeader(name = "Authorization") String token,@PathVariable("loanId") int loanId);
}
