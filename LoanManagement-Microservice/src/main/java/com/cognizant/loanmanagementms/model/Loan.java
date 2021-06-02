package com.cognizant.loanmanagementms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@Column(name = "loanproduct_id")
	@GeneratedValue
	private int loanProductId;

	@Column(name = "loanproduct_name")
	private String loanProductName;

	@Column(name = "max_Loan_eligible")
	private int maxLoanEligible;

	@Column(name = "interest") 
	private double interest;

	@Column(name = "tenure_year")
	private int tenureYear;

	
	public Loan() {
		super();
	}

	public Loan(int loanProductId, String loanProductName, int maxLoanEligible, double interest, int tenureYear) {
		super();
		this.loanProductId = loanProductId;
		this.loanProductName = loanProductName;
		this.maxLoanEligible = maxLoanEligible;
		this.interest = interest;
		this.tenureYear = tenureYear;
	}
	
	
	
	public int getLoanProductId() {
		return loanProductId;
	}

	public void setLoanProductId(int loanProductId) {
		this.loanProductId = loanProductId;
	}

	public String getLoanProductName() {
		return loanProductName;
	}

	public void setLoanProductName(String loanProductName) {
		this.loanProductName = loanProductName;
	}

	public int getMaxLoanEligible() {
		return maxLoanEligible;
	}

	public void setMaxLoanEligible(int maxLoanEligible) {
		this.maxLoanEligible = maxLoanEligible;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getTenureYear() {
		return tenureYear;
	}

	public void setTenureYear(int tenureYear) {
		this.tenureYear = tenureYear;
	}



	@Override
	public String toString() {
		return "Loan [loanProductId=" + loanProductId + ", loanProductName=" + loanProductName + ", maxLoanEligible="
				+ maxLoanEligible + ", interest=" + interest + ", tenureYear=" + tenureYear 
				+ ", customerloan=" + "]";
	}


}