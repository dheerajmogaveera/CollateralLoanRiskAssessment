package com.mfpe.loanwebportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.loanwebportal.feign.LoanFeign;
import com.mfpe.loanwebportal.modelvo.CollateralCashDepositsVO;
import com.mfpe.loanwebportal.modelvo.CollateralRealEsatateVO;

@Service
public class CollateralDaoImpl implements CollateralDao {
	
	@Autowired
	LoanFeign loanFeign;

	public ResponseEntity<CollateralRealEsatateVO> saveRealEstateCollaterals(int loanId, CollateralRealEsatateVO collateral, String token){
		return loanFeign.saveCollateralForRealEstate(token,loanId, collateral);
	}

	public ResponseEntity<CollateralCashDepositsVO> saveCashDepositCollaterals(int loanId, CollateralCashDepositsVO collateral, String token) {
		return loanFeign.saveCollateralForCashDesposit(token,loanId, collateral);
	}
}
