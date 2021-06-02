package com.cognizant.riskassessmentms.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.riskassessmentms.client.AuthClient;
import com.cognizant.riskassessmentms.client.CollateralClient;
import com.cognizant.riskassessmentms.client.CustomerLoanClient;
import com.cognizant.riskassessmentms.exception.InvalidTokenException;
import com.cognizant.riskassessmentms.model.AuthResponse;
import com.cognizant.riskassessmentms.model.CollateralMarketValueCashDeposits;
import com.cognizant.riskassessmentms.model.CollateralMarketValueRealEstate;
import com.cognizant.riskassessmentms.service.RiskAssessmentImpl;


@SpringBootTest
class RiskAssessmentControllerTest {

	@Mock
	RiskAssessmentImpl riskimpl;
	
	@Mock
	CollateralMarketValueRealEstate cre;
	
	@Mock
	CollateralMarketValueCashDeposits cce;
	
	@Mock
	CollateralClient client;
	
	@InjectMocks
	RiskAssessmentController rc; 
	
	@Mock
	CustomerLoanClient loanclient;
	
	@Mock
	AuthClient authclient;
	
	@Test
	void test() {
	}
	
	
	@Test
	public void getRealEstateRiskPositiveTest()
	{  
		AuthResponse ar=new AuthResponse();
		ar.setValid(true);
		when(authclient.verifyToken("")).thenReturn(ar);
		assertEquals(200, rc.getRiskForRealEstate("", 1).getStatusCodeValue());
	}
	
	@Test
	public void getRealEstateRiskNegativeTest()
	{  
		try {
		AuthResponse ar=new AuthResponse();
		ar.setValid(false);
		when(authclient.verifyToken("")).thenReturn(ar);
		rc.getRiskForRealEstate("", 1);
		}
		catch(Exception e)
		{
			assertEquals(InvalidTokenException.class,e.getClass());
		}
	}
	
	@Test
	public void getCashDepositRiskTest()
	{  
		AuthResponse ar=new AuthResponse();
		ar.setValid(true);
		when(authclient.verifyToken("")).thenReturn(ar);
		assertEquals(200, rc.getRiskForRealEstate("", 1).getStatusCodeValue());
	}
	
	@Test
	public void getCashDepositRiskNegativeTest()
	{  
		try {
		AuthResponse ar=new AuthResponse();
		ar.setValid(false);
		when(authclient.verifyToken("")).thenReturn(ar);
		rc.getRiskForCashDeposit("", 1);
		}
		catch(Exception e)
		{
			assertEquals(InvalidTokenException.class,e.getClass());
		}
	}
}
