package com.mfpe.loanwebportal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.loanwebportal.modelvo.RiskVO;

@FeignClient(name="RISK-ASSESSMENT", url="http://ij018po1riskmicroservice-env.eba-9vvrjxtz.us-east-2.elasticbeanstalk.com")
public interface RiskFeign {
	@GetMapping("getCollateralRisk/realEstate/{loanId}")
	public ResponseEntity<RiskVO> calculateRealEstateCollateralRisk(@RequestHeader(name="Authorization") String token, @PathVariable("loanId") int loanId) ;
	
	@GetMapping("getCollateralRisk/cashDeposit/{loanId}")
	public ResponseEntity<RiskVO> calculateCashDepositCollateralRisk(@RequestHeader(name="Authorization") String token, @PathVariable("loanId") int loanId) ;
}
