package com.mfpe.loanwebportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.loanwebportal.feign.RiskFeign;
import com.mfpe.loanwebportal.modelvo.RiskVO;

@Service
public class RiskDaoImpl implements RiskDao {
	
	@Autowired
	RiskFeign riskFeign;

	public ResponseEntity<RiskVO> getRealEstateCollateralRisk(int loanId, String token) {
		return riskFeign.calculateRealEstateCollateralRisk(token ,loanId);
	}

	public ResponseEntity<RiskVO> getCashDepositCollateralRisk(int loanId, String token) {
		return riskFeign.calculateCashDepositCollateralRisk(token , loanId);
	}
	
}
