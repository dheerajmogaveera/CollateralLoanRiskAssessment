package com.cognizant.loanManagement.TestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.cognizant.loanmanagementms.model.Customer;
import com.cognizant.loanmanagementms.model.CustomerLoan;
import com.cognizant.loanmanagementms.model.Loan;
import com.cognizant.loanmanagementms.repository.CustomerLoanRepository;
import com.cognizant.loanmanagementms.service.LoanService;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class LoanServiceTestCase {

	@Mock
	private CustomerLoanRepository customerLoanRepository;

	@InjectMocks
	LoanService loanService;
	



	@Test
	void testFindByLoanId() throws Exception {
		Customer customer = new Customer(101, "Raza");
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));
		assertEquals(1, loanService.findByCustomerLoanId(1).getLoanId());
		
	}

	@Test
	void testFindByCustomerLoanId_2() throws Exception {
		Customer customer = new Customer(1, "Raza");
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));
		assertNotEquals(2, loanService.findByCustomerLoanId(1).getLoanId());
	}

	@Test
	void testFindByCustomerLoanId_3() throws Exception {
		Customer customer = new Customer(1, "Ansh");
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));
		assertEquals(1, loanService.findByCustomerLoanId(1).getLoanId());
		assertNotEquals(2, loanService.findByCustomerLoanId(1).getLoanId());
	}

	@Test
	void testFindByCustomerLoanId_4() throws Exception {
		Customer customer = new Customer(1, "Raza");
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));
		assertNotEquals(5000, loanService.findByCustomerLoanId(1).getLoanPrincipal());
	}

	@Test

	void testFindByCustomerLoanId_5() throws Exception {
		Customer customer = new Customer(1, "Raza");
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));
		assertNotEquals(15, loanService.findByCustomerLoanId(1).getTenureYear());
	}

	@Test

	void testFindByCustomerLoanId_6() throws Exception {
		Customer customer = null;
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));
		assertNotEquals(15, loanService.findByCustomerLoanId(1).getTenureYear());
	}

	@Test

	void testFindByCustomerLoanId_7() throws Exception {
		Customer customer = new Customer(1, "Raza");
		Loan loan = null;
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));
		assertNotEquals(15, loanService.findByCustomerLoanId(1).getTenureYear());
	}

	@Test

	void testFindByCustomerLoanId_8() throws Exception {
		Customer customer = null;
		Loan loan = null;
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findById(1)).thenReturn(Optional.of(customerLoan));

		assertNotEquals(15, loanService.findByCustomerLoanId(1).getTenureYear());
	}

	

	@Test

	void testSaveCustomerLoan_1() throws Exception {
		Customer customer = new Customer(1, "Raza");
		CustomerLoan customerLoan = new CustomerLoan(1, 2000000.0, 7, 8000, customer);
		when(customerLoanRepository.save(customerLoan)).thenReturn(customerLoan);
		assertEquals(1, loanService.saveCustomerLoanDetalis(customerLoan).getLoanId());
	}

	@Test

	void testSaveCustomerLoan_2() throws Exception {
		Customer customer = new Customer(1, "Ansh");
		CustomerLoan customerLoan = new CustomerLoan(1, 2000000.0, 7, 8000, customer);
		when(customerLoanRepository.save(customerLoan)).thenReturn(customerLoan);
		assertNotEquals(4, loanService.saveCustomerLoanDetalis(customerLoan).getLoanId());
	}

	@Test

	void testSaveCustomerLoan_3() throws Exception {
		Customer customer = new Customer(1, "Raza");
		CustomerLoan customerLoan = new CustomerLoan(1, 2000000.0, 7, 8000, customer);
		when(customerLoanRepository.save(customerLoan)).thenReturn(customerLoan);
		assertEquals(7, loanService.saveCustomerLoanDetalis(customerLoan).getTenureYear());
	}

	@Test
	void testSaveCustomerLoan_4() throws Exception {
		Customer customer = new Customer(1, "Ansh");
		CustomerLoan customerLoan = new CustomerLoan(1, 2000000.0, 7, 8000, customer);
		when(customerLoanRepository.save(customerLoan)).thenReturn(customerLoan);
		assertNotEquals(9, loanService.saveCustomerLoanDetalis(customerLoan).getTenureYear());
	}


	@Test
	void testGetAllCustomerLoan() throws Exception {
		Customer customer = new Customer(1, "Raza");
		CustomerLoan customerLoan = new CustomerLoan(1, 1000000.0, 8, 5000, customer);
		when(customerLoanRepository.findAll()).thenReturn(List.of(customerLoan));
		assertEquals(1, loanService.getAllCustomerLoan().get(0).getLoanId());

	}

	@Test
	
	void testGetAllCustomerLoan_1() throws Exception {
		Customer customer = new Customer(1,"Raza");
		CustomerLoan customerLoan = new CustomerLoan(1,1000000.0,8,5000,customer);
		when(customerLoanRepository.findAll()).thenReturn(List.of(customerLoan));
		assertEquals(1,loanService.getAllCustomerLoan().get(0).getLoanId());
		
        }
	
	@Test
		void testGetAllCustomerLoan_2() throws Exception {
		Customer customer = new Customer(1,"Raza");
		CustomerLoan customerLoan = new CustomerLoan(1,1000000.0,8,5000,customer);
		when(customerLoanRepository.findAll()).thenReturn(List.of(customerLoan));
		assertNotEquals(2,loanService.getAllCustomerLoan().get(0).getLoanId());
		
	}
	
	@Test
	
	void testGetAllCustomerLoan_3() throws Exception {
		Customer customer = new Customer(1,"Raza");
		CustomerLoan customerLoan = new CustomerLoan(1,1000000.0,8,5000,customer);
		when(customerLoanRepository.findAll()).thenReturn(List.of(customerLoan));
		assertNotEquals(7000,loanService.getAllCustomerLoan().get(0).getTenureYear());
		
    }
	
	@Test
	
	void testGetAllCustomerLoan_4() throws Exception {
		Customer customer = new Customer(1,"Raza");
		CustomerLoan customerLoan = new CustomerLoan(1,1000000.0,8,5000,customer);
		when(customerLoanRepository.findAll()).thenReturn(List.of(customerLoan));
		assertNotEquals(2.0,loanService.getAllCustomerLoan().get(0).getInterest());
		
    }



}
