package com.mfpe.loanwebportal.service;

import org.springframework.http.ResponseEntity;

import com.mfpe.loanwebportal.modelvo.CollateralCashDepositsVO;
import com.mfpe.loanwebportal.modelvo.CollateralRealEsatateVO;

public interface CollateralDao {
	public ResponseEntity<CollateralRealEsatateVO> saveRealEstateCollaterals(int loanId, CollateralRealEsatateVO collateral, String token) ;
	public ResponseEntity<CollateralCashDepositsVO> saveCashDepositCollaterals(int loanId, CollateralCashDepositsVO collateral, String token);
}
