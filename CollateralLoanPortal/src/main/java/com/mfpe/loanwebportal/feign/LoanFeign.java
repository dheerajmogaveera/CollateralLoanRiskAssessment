package com.mfpe.loanwebportal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.loanwebportal.modelvo.CollateralCashDepositsVO;
import com.mfpe.loanwebportal.modelvo.CollateralRealEsatateVO;
import com.mfpe.loanwebportal.modelvo.CustomerLoanVO;

@FeignClient(name="LOAN-MANAGEMENT-SERVICE", url="http://ij018po1loanmicroservice-env.eba-apmsmukx.us-east-2.elasticbeanstalk.com")
public interface LoanFeign {
	
	@PostMapping("/realEstate/{loanId}")
	public ResponseEntity<CollateralRealEsatateVO> saveCollateralForRealEstate(@RequestHeader("Authorization") String token, @PathVariable("loanId") int loanId, @RequestBody CollateralRealEsatateVO collateral) ;
	
	@PostMapping("/cashDeposit/{loanId}")
	public ResponseEntity<CollateralCashDepositsVO> saveCollateralForCashDesposit(@RequestHeader("Authorization") String token, @PathVariable("loanId") int loanId, @RequestBody CollateralCashDepositsVO collateral) ;
	
	@GetMapping("/loan/{loanId}")
	public ResponseEntity<CustomerLoanVO> getLoanDetails(@PathVariable("loanId") int loanId, @RequestHeader("Authorization") String token) ;
	
}
