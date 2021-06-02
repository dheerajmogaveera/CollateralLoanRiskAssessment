package com.mfpe.loanwebportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.loanwebportal.feign.AuthClient;
import com.mfpe.loanwebportal.feign.LoanFeign;
import com.mfpe.loanwebportal.modelvo.CustomerLoanVO;

@Service
public class LoanInfoDaoImpl implements LoanInfoDao{
	@Autowired
	private LoanFeign loanFeign;
	
	@Autowired
	AuthClient authclient;

	public ResponseEntity<CustomerLoanVO> getLoanInfo(int loanId, String token)  {
		return loanFeign.getLoanDetails(loanId, token);
	}
	
	
	
}
