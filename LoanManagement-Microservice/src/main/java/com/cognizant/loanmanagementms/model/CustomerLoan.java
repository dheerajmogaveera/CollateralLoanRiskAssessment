package com.cognizant.loanmanagementms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_loan")
public class CustomerLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
	private double loanPrincipal;
	private int tenureYear;
	private double interest;
	private String type;
	@Column(name="loan_type")
	private String loanType;
	@OneToOne(mappedBy = "customerLoan")
	@JoinColumn(name = "customer_id")
	private Customer customer;


	public CustomerLoan() {
		super();
	}
	
	
	public CustomerLoan(int loanId, double loanPrincipal, int tenureYear, double interest, Customer customer) {
		super();
		this.loanId = loanId;
		this.loanPrincipal = loanPrincipal;
		this.tenureYear = tenureYear;
		this.interest = interest;
		this.customer = customer;
	}
	
	
	
	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public double getLoanPrincipal() {
		return loanPrincipal;
	}

	public void setLoanPrincipal(double loanPrincipal) {
		this.loanPrincipal = loanPrincipal;
	}

	public int getTenureYear() {
		return tenureYear;
	}

	public void setTenureYear(int tenureYear) {
		this.tenureYear = tenureYear;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "CustomerLoan [loanId=" + loanId + ", loanPrincipal=" + loanPrincipal + ", tenureYear=" + tenureYear
				+ ", interest=" + interest + ", type=" + type + ", loanType=" + loanType + ", customer=" + customer
				+ "]";
	}

}
