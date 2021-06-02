package com.cognizant.riskassessmentms.model;

public class CustomerLoan {
	private int loanId;

	private int loanProductId;
	private int customerId;

	private double loanPrincipal;

	private int tenureYear;

	private double interest;

	private int emi;

	private int collateralId;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getLoanProductId() {
		return loanProductId;
	}

	public void setLoanProductId(int loanProductId) {
		this.loanProductId = loanProductId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public int getCollateralId() {
		return collateralId;
	}

	public void setCollateralId(int collateralId) {
		this.collateralId = collateralId;
	}
	
	
}
