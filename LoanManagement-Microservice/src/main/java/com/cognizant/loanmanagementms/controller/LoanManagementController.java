package com.cognizant.loanmanagementms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loanmanagementms.client.AuthClient;
import com.cognizant.loanmanagementms.client.CollateralClient;
import com.cognizant.loanmanagementms.exception.CustomerLoanNotFoundException;
import com.cognizant.loanmanagementms.exception.InvalidTokenException;
import com.cognizant.loanmanagementms.model.CollateralCashDeposits;
import com.cognizant.loanmanagementms.model.CollateralRealEstate;
import com.cognizant.loanmanagementms.model.CustomerLoan;
import com.cognizant.loanmanagementms.service.LoanService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class LoanManagementController {

	@Autowired
	LoanService loanService;
	@Autowired
	CollateralClient client;
	@Autowired
	AuthClient auth;
	static final Logger logger = LoggerFactory.getLogger(LoanManagementController.class);
	
	@GetMapping(path = "/loan/{loanId}")
	public ResponseEntity<CustomerLoan> getById(@PathVariable("loanId") int loanId,@RequestHeader(name = "Authorization") String token)  {
		logger.info("customerLoanService method called");
		var authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
			return new ResponseEntity<>(loanService.findByCustomerLoanId(loanId), HttpStatus.OK);
		else
			throw new InvalidTokenException("Invalid Token");
		
	}
	
	@GetMapping("/getLoanDetails")
	public ResponseEntity<List<CustomerLoan>> getAllLoanDetails(@RequestHeader(name = "Authorization") String token) {
		logger.info("Get all Loan method called");
		var authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
			return new ResponseEntity<>(loanService.getAllCustomerLoan(), HttpStatus.OK);
		else
			throw new InvalidTokenException("Invalid Token");
	}
	
	@PostMapping("/saveLoanDetails")
	public  ResponseEntity<CustomerLoan> save(@RequestHeader(name = "Authorization") String token,@RequestBody CustomerLoan customerLoan) {
		logger.info("Saving all the Loan Details");
		var authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
			return new ResponseEntity<>(loanService.saveCustomerLoanDetalis(customerLoan),HttpStatus.OK);
		else
			throw new InvalidTokenException("Invalid Token");
		
	}
	
	@PostMapping(path = "/realEstate/{loanId}")
	public ResponseEntity<CollateralRealEstate> saveCollateralRealEstate(@RequestHeader(name = "Authorization") String token,@PathVariable("loanId") int loanId,@RequestBody CollateralRealEstate collateralRealEstate){
		var authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
		{		
				collateralRealEstate.setLoanId(loanId);
				return new ResponseEntity<>(client.saveCollateralsForRealEstate(token,collateralRealEstate).getBody(),HttpStatus.OK);
		}
		else
			throw new InvalidTokenException("Invalid Token");
	}
	
	@PostMapping(path = "/cashDeposit/{loanId}")
	public ResponseEntity<CollateralCashDeposits> saveCollateralCashDeposit(@RequestHeader(name = "Authorization") String token,@PathVariable("loanId") int loanId,@RequestBody CollateralCashDeposits collateralCashDeposits) {
		var authResponse = auth.verifyToken(token);
		if(authResponse.isValid())
			return new ResponseEntity<>(client.saveCollateralsForCashDeposits(token,collateralCashDeposits).getBody(),HttpStatus.OK);
		else
			throw new InvalidTokenException("Invalid Token");
	}
}
