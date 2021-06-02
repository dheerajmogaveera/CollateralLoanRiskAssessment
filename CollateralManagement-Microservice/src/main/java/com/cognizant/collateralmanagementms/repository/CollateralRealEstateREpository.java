package com.cognizant.collateralmanagementms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.collateralmanagementms.model.CollateralRealEstate;

@Repository
public interface CollateralRealEstateREpository extends JpaRepository<CollateralRealEstate, Integer> {

	public CollateralRealEstate findByLoanId(int loanId);
	
}
