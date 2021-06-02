package com.cognizant.loanmanagementms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.loanmanagementms.exception.CustomerLoanNotFoundException;
import com.cognizant.loanmanagementms.model.CustomerLoan;
import com.cognizant.loanmanagementms.repository.CustomerLoanRepository;


@Service
public class LoanService {
	
	@Autowired
	CustomerLoanRepository customerLoanRepository;
	
	public CustomerLoan saveCustomerLoanDetalis(CustomerLoan customerLoan) {
		return customerLoanRepository.save(customerLoan);
	}
	
	public List<CustomerLoan> getAllCustomerLoan() {
		return customerLoanRepository.findAll();
	
	}

	public CustomerLoan findByCustomerLoanId(int loanId)throws CustomerLoanNotFoundException {
		Optional<CustomerLoan> loan =customerLoanRepository.findById(loanId);
		if(!loan.isPresent()) {
			throw new CustomerLoanNotFoundException("No Loan with ID: "+loanId+" exists!!");
		}
		return customerLoanRepository.findById(loanId).get();
	}


}
