package com.cognizant.collateralmanagementms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.collateralmanagementms.model.CollateralCashDeposits;

@Repository
public interface CollateralCashDepositsRepository extends JpaRepository<CollateralCashDeposits, Integer> {

	
	public CollateralCashDeposits findByLoanId(int loanId);
	
}
