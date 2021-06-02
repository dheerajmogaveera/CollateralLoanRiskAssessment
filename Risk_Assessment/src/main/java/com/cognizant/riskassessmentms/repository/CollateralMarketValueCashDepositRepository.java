package com.cognizant.riskassessmentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.riskassessmentms.model.CollateralMarketValueCashDeposits;

public interface  CollateralMarketValueCashDepositRepository extends JpaRepository<CollateralMarketValueCashDeposits, Integer>{
	
	CollateralMarketValueCashDeposits findByBankName(String bankName);
}
