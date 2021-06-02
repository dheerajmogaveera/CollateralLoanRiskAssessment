package com.cognizant.loanmanagementms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.loanmanagementms.model.CustomerLoan;

@Repository
public interface CustomerLoanRepository extends JpaRepository<CustomerLoan, Integer> {
}
