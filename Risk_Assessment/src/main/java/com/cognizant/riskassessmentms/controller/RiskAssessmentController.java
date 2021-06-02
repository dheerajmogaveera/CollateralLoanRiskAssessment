package com.cognizant.riskassessmentms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.riskassessmentms.client.AuthClient;
import com.cognizant.riskassessmentms.client.CollateralClient;
import com.cognizant.riskassessmentms.client.CustomerLoanClient;
import com.cognizant.riskassessmentms.exception.InvalidTokenException;
import com.cognizant.riskassessmentms.model.AuthResponse;
import com.cognizant.riskassessmentms.model.CollateralRisk;
import com.cognizant.riskassessmentms.service.RiskAssessmentImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RiskAssessmentController {

	private static final Logger logger = LoggerFactory.getLogger(RiskAssessmentController.class);

	@Autowired
	AuthClient auth;

	@Autowired
	CollateralClient collateralClient;

	@Autowired
	CustomerLoanClient customerLoanCLient;

	@Autowired
	RiskAssessmentImpl riskAssessmentImpl;

	@GetMapping("getCollateralRisk/realEstate/{loanId}")
	public ResponseEntity<CollateralRisk> getRiskForRealEstate(@RequestHeader("Authorization") String token,
			@PathVariable("loanId") int loanId) {
		logger.info("Calculating risk for real estate collateral");
		AuthResponse authResponse = auth.verifyToken(token);
		if (authResponse.isValid()) {
			CollateralRisk collateralRisk = riskAssessmentImpl.getRiskForRealEstate(token, loanId);
			return new ResponseEntity<CollateralRisk>(collateralRisk, HttpStatus.OK);

		} else {
			throw new InvalidTokenException("Invalid token");
		}

	}


	@GetMapping("getCollateralRisk/cashDeposit/{loanId}")
	public ResponseEntity<CollateralRisk> getRiskForCashDeposit(@RequestHeader("Authorization") String token,
			@PathVariable("loanId") int loanId){
		logger.info("Calculating risk for cash deposit collateral");
		AuthResponse authResponse = auth.verifyToken(token);
		if (authResponse.isValid()) {
			CollateralRisk collateralRisk = riskAssessmentImpl.getRiskForCashDeposits(token, loanId);
			return new ResponseEntity<CollateralRisk>(collateralRisk, HttpStatus.OK);

		} else {
			throw new InvalidTokenException("Invalid token");
		}

	}
}