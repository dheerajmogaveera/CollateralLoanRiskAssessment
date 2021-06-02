package com.mfpe.loanwebportal.service;

import org.springframework.http.ResponseEntity;

import com.mfpe.loanwebportal.modelvo.RiskVO;

public interface RiskDao {
	public ResponseEntity<RiskVO> getRealEstateCollateralRisk(int loanId, String token) ;
	public ResponseEntity<RiskVO> getCashDepositCollateralRisk(int loanId, String token);
}
