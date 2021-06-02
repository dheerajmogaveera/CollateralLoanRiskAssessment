package com.cognizant.collateralmanagementms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.collateralmanagementms.model.CollateralCashDeposits;
import com.cognizant.collateralmanagementms.model.CollateralRealEstate;
import com.cognizant.collateralmanagementms.repository.CollateralCashDepositsRepository;
import com.cognizant.collateralmanagementms.repository.CollateralRealEstateREpository;

@Service
public class CollateralManagementService {

	@Autowired
	private CollateralRealEstateREpository realestateRepo;

	@Autowired
	private CollateralCashDepositsRepository cashdepositRepo;

	public CollateralRealEstate getCollateralRealEstate(int loanId) {

		CollateralRealEstate real = realestateRepo.findByLoanId(loanId);
		if(real!=null)
		  return real;
		else
			return null;

	}

	public CollateralRealEstate saveCollateralForRealEstate(CollateralRealEstate realEstate) {
		return realestateRepo.save(realEstate);
	}

	public CollateralCashDeposits getCollateralCashDeposits(int loanId) {

		CollateralCashDeposits cash = cashdepositRepo.findByLoanId(loanId);
		if(cash!=null)
		  return cash;
		else {
			return null;
		}
	}

	public CollateralCashDeposits saveCollateralCashDeposits(CollateralCashDeposits cashDeposits) {
		return cashdepositRepo.save(cashDeposits);
	}
}
