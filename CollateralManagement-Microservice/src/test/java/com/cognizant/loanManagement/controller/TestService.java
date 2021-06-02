package com.cognizant.loanManagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.collateralmanagementms.exception.CollateralNotFoundException;
import com.cognizant.collateralmanagementms.model.CollateralRealEstate;
import com.cognizant.collateralmanagementms.repository.CollateralCashDepositsRepository;
import com.cognizant.collateralmanagementms.repository.CollateralRealEstateREpository;
import com.cognizant.collateralmanagementms.service.CollateralManagementService;

@SpringBootTest
class TestService {

	@Mock
	CollateralCashDepositsRepository cashDepositsRepository;
	@Mock
	CollateralRealEstateREpository collateralRealEstateREpository;
	@InjectMocks
	CollateralManagementService collateralManagementService;
	
	
	
	@Test
	void testgetCollateralRealEstate_1() throws CollateralNotFoundException{
		
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"diya","20-14","lucknow","Uttar Pradesh", 500);
		when(collateralRealEstateREpository.findByLoanId(1)).thenReturn(collateralRealEstate);
		assertEquals(1,collateralManagementService.getCollateralRealEstate(1).getLoanId());
		
		
//		when(collateralRealEstateRepo.findById(1)).thenReturn(Optional.of(collateralRealEstate));
//		assertEquals(1,collateralServiceImpl.getCollateralRealEstate(1).getLoanId());
	}

}
