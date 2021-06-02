package com.mfpe.loanwebportal.service;

import org.springframework.http.ResponseEntity;

import com.mfpe.loanwebportal.modelvo.CustomerLoanVO;

public interface LoanInfoDao {
	public ResponseEntity<CustomerLoanVO> getLoanInfo(int loanId, String token) ;

}
