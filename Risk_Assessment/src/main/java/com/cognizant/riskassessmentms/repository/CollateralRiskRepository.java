package com.cognizant.riskassessmentms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.riskassessmentms.model.CollateralRisk;


public interface CollateralRiskRepository extends JpaRepository<CollateralRisk, Integer> {
	Optional<CollateralRisk> findByLoanIdAndCollateralType(int loanId,String collateralType);
}
