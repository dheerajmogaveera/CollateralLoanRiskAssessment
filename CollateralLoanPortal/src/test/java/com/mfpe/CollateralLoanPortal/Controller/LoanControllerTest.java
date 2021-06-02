package com.mfpe.CollateralLoanPortal.Controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.mfpe.loanwebportal.modelvo.CustomerLoanVO;
import com.mfpe.loanwebportal.service.LoanInfoDaoImpl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest
class LoanControllerTest {

	
	@Test
	 void testLoanController() throws Exception{

	}

}
