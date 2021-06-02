package com.cognizant.collateralmanagementms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollateralCashDeposits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collateral_id")
	private int collateralId;
	@Column(name = "loan_id")
	private int loanId;
	@Column(name = "owner_name")
	private String ownerName;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "account_number")
	private long accountNumber;
	@Column(name = "deposit_amount")
	private double depositAmount;
	@Column(name = "lock_period")
	private double lockPeriod;
	public CollateralCashDeposits() {
		super();
	}
	public CollateralCashDeposits(int collateralId, int loanId, String ownerName, String bankName, long accountNumber,
			double depositAmount, double lockPeriod) {
		super();
		this.collateralId = collateralId;
		this.loanId = loanId;
		this.ownerName = ownerName;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.depositAmount = depositAmount;
		this.lockPeriod = lockPeriod;
	}
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
	@Override
	public String toString() {
		return "CollateralCashDeposits [collateralId=" + collateralId + ", loanId=" + loanId + ", ownerName="
				+ ownerName + ", bankName=" + bankName + ", accountNumber=" + accountNumber + ", depositAmount="
				+ depositAmount + ", lockPeriod=" + lockPeriod + "]";
	}
	
	


}
