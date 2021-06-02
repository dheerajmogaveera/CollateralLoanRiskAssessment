package com.cognizant.loanmanagementms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.loanmanagementms.model.CollateralCashDeposits;
import com.cognizant.loanmanagementms.model.CollateralRealEstate;



@FeignClient(/*"COLLATERAL-MANAGEMENT-SERVICE"*/name = "Collateral-Management-Service",url="http://ij018pod1collateralmicroservice-env.eba-dwby7efn.us-east-2.elasticbeanstalk.com")
public interface CollateralClient {

	
	@PostMapping(path = "/realEstate")
	public ResponseEntity<CollateralRealEstate> saveCollateralsForRealEstate(@RequestHeader(name = "Authorization") String token,@RequestBody CollateralRealEstate realEstates);

	
	@PostMapping(path = "/cashDeposits")
	public ResponseEntity<CollateralCashDeposits> saveCollateralsForCashDeposits(@RequestHeader(name = "Authorization") String token,@RequestBody CollateralCashDeposits cashDeposits);
    
	@GetMapping("/realEstate/{loanId}")
	public ResponseEntity<CollateralRealEstate> getByIdRealEstate(@RequestHeader(name = "Authorization") String token,@PathVariable("loanId") int loanId);
	
	@GetMapping("/cashdeposit/{loanId}")
	public ResponseEntity<CollateralCashDeposits> getByIdCashDeposit(@RequestHeader(name = "Authorization") String token,@PathVariable("loanId") int loanId);
}
