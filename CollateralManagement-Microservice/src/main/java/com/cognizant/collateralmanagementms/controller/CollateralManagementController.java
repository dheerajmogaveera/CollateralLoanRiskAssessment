package com.cognizant.collateralmanagementms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.collateralmanagementms.client.AuthClient;
import com.cognizant.collateralmanagementms.exception.InvalidTokenException;
import com.cognizant.collateralmanagementms.model.AuthResponse;
import com.cognizant.collateralmanagementms.model.CollateralCashDeposits;
import com.cognizant.collateralmanagementms.model.CollateralRealEstate;
import com.cognizant.collateralmanagementms.service.CollateralManagementService;


@RestController
public class CollateralManagementController {
	
	@Autowired
	private CollateralManagementService collateralManagementService;
	
	@Autowired
	private AuthClient auth;
	
	@GetMapping("/realEstate/{loanId}")
	public ResponseEntity<CollateralRealEstate> getByIdRealEstate(@RequestHeader(name = "Authorization") String token,@PathVariable int loanId){
		AuthResponse authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
		{
		CollateralRealEstate collateralRealEstate= collateralManagementService.getCollateralRealEstate(loanId);
		return new ResponseEntity<CollateralRealEstate>(collateralRealEstate,HttpStatus.OK);
		}
		else
			throw new InvalidTokenException("Invalid Token");
		
	}
	
	@GetMapping("/cashdeposit/{loanId}")
	public ResponseEntity<CollateralCashDeposits> getByIdCashDeposit(@RequestHeader(name = "Authorization") String token,@PathVariable int loanId){
		AuthResponse authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
		{
		CollateralCashDeposits collateralCashdeposit= collateralManagementService.getCollateralCashDeposits(loanId);
		return new ResponseEntity<>(collateralCashdeposit,HttpStatus.OK);
		}
		else
			throw new InvalidTokenException("Invalid Token");
	}
	
	@PostMapping(path = "/realEstate")
	public ResponseEntity<CollateralRealEstate> saveCollateralForRealEstate(@RequestHeader(name = "Authorization") String token,@RequestBody CollateralRealEstate realEstate){
		AuthResponse authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
		{
		CollateralRealEstate collateralRealEstate = collateralManagementService.saveCollateralForRealEstate(realEstate);
		return new ResponseEntity<>(collateralRealEstate,HttpStatus.OK);
		}
		else
			throw new InvalidTokenException("Invalid Token");
	}
	
	@PostMapping(path = "/cashDeposits")
	public ResponseEntity<CollateralCashDeposits> saveCollateralForCashDeposits(@RequestHeader(name = "Authorization") String token,@RequestBody CollateralCashDeposits cashDeposits){
        
		AuthResponse authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
		{
		CollateralCashDeposits collateralcashDeposits = collateralManagementService.saveCollateralCashDeposits(cashDeposits);
		return new ResponseEntity<>(collateralcashDeposits,HttpStatus.OK);
		}
		else
			throw new InvalidTokenException("Invalid Token");
	}
		


}
