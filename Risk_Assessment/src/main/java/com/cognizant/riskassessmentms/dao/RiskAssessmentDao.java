package com.cognizant.riskassessmentms.dao;

import com.cognizant.riskassessmentms.exception.CollateralNotFoundException;
import com.cognizant.riskassessmentms.exception.CustomerLoanNotFoundException;
import com.cognizant.riskassessmentms.model.CollateralRisk;

public interface RiskAssessmentDao {
	CollateralRisk getRiskForRealEstate(String token, int loanId) throws  CollateralNotFoundException, CustomerLoanNotFoundException;

	CollateralRisk getRiskForCashDeposits(String token, int loanId) throws  CollateralNotFoundException, CustomerLoanNotFoundException;

}
