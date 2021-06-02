package com.cognizant.riskassessmentms.model;

public class CollateralCashDeposit {

	private int collateralId;
	private int loanId;

	private String ownerName;
	private String bankName;
	private long accountNumber;
	private double depositAmount;
	private double lockPeriod;
	public int getCollateralId() {
		return collateralId;
	}
	public void setCollateralId(int collateralId) {
		this.collateralId = collateralId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public double getLockPeriod() {
		return lockPeriod;
	}
	public void setLockPeriod(double lockPeriod) {
		this.lockPeriod = lockPeriod;
	}
	
	
}
