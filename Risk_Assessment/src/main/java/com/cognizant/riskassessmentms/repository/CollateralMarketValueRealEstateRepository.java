package com.cognizant.riskassessmentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.riskassessmentms.model.CollateralMarketValueRealEstate;


public interface CollateralMarketValueRealEstateRepository extends JpaRepository<CollateralMarketValueRealEstate, Integer> {

	CollateralMarketValueRealEstate findByCityAndState(String city,String state);
}
