package com.cognizant.loanManagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.collateralmanagementms.exception.CollateralNotFoundException;
import com.cognizant.collateralmanagementms.model.CollateralCashDeposits;
import com.cognizant.collateralmanagementms.model.CollateralRealEstate;
import com.cognizant.collateralmanagementms.repository.CollateralCashDepositsRepository;
import com.cognizant.collateralmanagementms.repository.CollateralRealEstateREpository;
import com.cognizant.collateralmanagementms.service.CollateralManagementService;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class TestController {

	@Mock
	private CollateralCashDepositsRepository collateralCashDepositRepo;
	@Mock
	private CollateralRealEstateREpository collateralRealEstateRepo;
	@InjectMocks
	CollateralManagementService collateralServiceImpl;
	
	
	@Test
	void testgetCollateralRealEstate_1()  {
		
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
	//	assertEquals(1, collateralRealEstate.getLoanId());
		when(collateralRealEstateRepo.findByLoanId(1)).thenReturn(collateralRealEstate);
		assertEquals(1,collateralServiceImpl.getCollateralRealEstate(1).getLoanId());
	}
	
	@Test
    void testgetCollateralRealEstate_2() {
		
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.findByLoanId(1)).thenReturn(collateralRealEstate);
		assertNotEquals(2,collateralServiceImpl.getCollateralRealEstate(1).getLoanId());
	}
	
	@Test
    void testgetCollateralRealEstate_3(){
		
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.findByLoanId(1)).thenReturn(collateralRealEstate);
		assertEquals("Nashik",collateralServiceImpl.getCollateralRealEstate(1).getCity());
		
	}
	@Test
    void testgetCollateralRealEstate_4(){
		
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.findByLoanId(1)).thenReturn(collateralRealEstate);
		assertNotEquals("lucknow ",collateralServiceImpl.getCollateralRealEstate(1).getCity());
		
	}
	@Test
    void testgetCollateralRealEstate_5() {
		
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.findByLoanId(1)).thenReturn(collateralRealEstate);
		assertEquals(500,collateralServiceImpl.getCollateralRealEstate(1).getAreaInFt());
	}
	@Test
    void testgetCollateralRealEstate_6() {
		
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.findByLoanId(1)).thenReturn(collateralRealEstate);
		assertNotEquals(250,collateralServiceImpl.getCollateralRealEstate(1).getAreaInFt());
	}
	@Test
	void testsaveCollateralForRealEstate_1(){
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.save(collateralRealEstate)).thenReturn(collateralRealEstate);
		assertEquals(1,collateralServiceImpl.saveCollateralForRealEstate(collateralRealEstate).getLoanId());
	}
	@Test
	void testsaveCollateralForRealEstate_2() {
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.save(collateralRealEstate)).thenReturn(collateralRealEstate);
		assertNotEquals(2,collateralServiceImpl.saveCollateralForRealEstate(collateralRealEstate).getLoanId());
	}
	@Test
	void testsaveCollateralForRealEstate_3() {
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.save(collateralRealEstate)).thenReturn(collateralRealEstate);
		assertEquals(500,collateralServiceImpl.saveCollateralForRealEstate(collateralRealEstate).getAreaInFt());
	}
	@Test
	void testsaveCollateralForRealEstate_4(){

		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.save(collateralRealEstate)).thenReturn(collateralRealEstate);
		assertNotEquals(250,collateralServiceImpl.saveCollateralForRealEstate(collateralRealEstate).getAreaInFt());
	}
	
	@Test
	void testsaveCollateralForRealEstate_5()// throws  CollateralNotFoundException, DataNotPresentException
	{
		
		CollateralRealEstate collateralRealEstate=new CollateralRealEstate(1,1,"Raza","20-14","Nashik","MH", 500);
		when(collateralRealEstateRepo.save(collateralRealEstate)).thenReturn(collateralRealEstate);
		assertEquals("Raza",collateralServiceImpl.saveCollateralForRealEstate(collateralRealEstate).getOwnerName());
		
	}
	
	@Test
	void testgetCollateralCashDeposits_1() //throws CollateralNotFoundException 
	{
		
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.findByLoanId(1)).thenReturn(collateralCashDeposits);
		assertEquals(1,collateralServiceImpl.getCollateralCashDeposits(1).getLoanId());
	}
	@Test
	void testgetCollateralCashDeposits_2() {
		
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.findByLoanId(1)).thenReturn(collateralCashDeposits);
		assertNotEquals(2,collateralServiceImpl.getCollateralCashDeposits(1).getLoanId());
	}
	@Test
	void testgetCollateralCashDeposits_3(){
		
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.findByLoanId(1)).thenReturn(collateralCashDeposits);
		assertEquals("SBI",collateralServiceImpl.getCollateralCashDeposits(1).getBankName());
		
	}
	@Test
	void testgetCollateralCashDeposits_4()// throws CollateralNotFoundException
	{
		
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.findByLoanId(1)).thenReturn(collateralCashDeposits);
		assertEquals(50000,collateralServiceImpl.getCollateralCashDeposits(1).getDepositAmount());
		
	}
	@Test
	void testgetCollateralCashDeposits_5()// throws CollateralNotFoundException 
	{
		
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.findByLoanId(1)).thenReturn(collateralCashDeposits);
		assertEquals(789452457,collateralServiceImpl.getCollateralCashDeposits(1).getAccountNumber());
		
	}
	@Test
	void testgetCollateralCashDeposits_6()// throws CollateralNotFoundException 
	{
		
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.findByLoanId(1)).thenReturn(collateralCashDeposits);
		assertNotEquals(78945245,collateralServiceImpl.getCollateralCashDeposits(1).getAccountNumber());
		
	}
	@Test
	void testsaveCollateralCashDeposits_1() //throws  CollateralNotFoundException, DataNotPresentException
	{
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.save(collateralCashDeposits)).thenReturn(collateralCashDeposits);
		assertEquals(1,collateralServiceImpl.saveCollateralCashDeposits(collateralCashDeposits).getLoanId());	
	}
	@Test
	void testsaveCollateralCashDeposits_2() //throws  CollateralNotFoundException, DataNotPresentException
	{
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.save(collateralCashDeposits)).thenReturn(collateralCashDeposits);
		assertNotEquals(2,collateralServiceImpl.saveCollateralCashDeposits(collateralCashDeposits).getLoanId());	
	}
	@Test
	void testsaveCollateralCashDeposits_3()// throws  CollateralNotFoundException, DataNotPresentException
	{
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.save(collateralCashDeposits)).thenReturn(collateralCashDeposits);
		assertEquals(4.0,collateralServiceImpl.saveCollateralCashDeposits(collateralCashDeposits).getLockPeriod());	
	}
	@Test
	void testsaveCollateralCashDeposits_4() //throws  CollateralNotFoundException, DataNotPresentException
	{
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.save(collateralCashDeposits)).thenReturn(collateralCashDeposits);
		assertNotEquals(5,collateralServiceImpl.saveCollateralCashDeposits(collateralCashDeposits).getLockPeriod());	
	}

	@Test
	void testsaveCollateralCashDeposits_5() //throws  CollateralNotFoundException, DataNotPresentException
	{
		
		CollateralCashDeposits collateralCashDeposits=new CollateralCashDeposits(2,1,"Vamsi","SBI",789452457,50000.0,4.0);
		when(collateralCashDepositRepo.save(collateralCashDeposits)).thenReturn(collateralCashDeposits);
		assertEquals("Vamsi",collateralServiceImpl.saveCollateralCashDeposits(collateralCashDeposits).getOwnerName());	
	}
}
