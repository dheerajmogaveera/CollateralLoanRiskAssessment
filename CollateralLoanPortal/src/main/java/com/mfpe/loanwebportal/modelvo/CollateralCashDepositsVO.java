package com.mfpe.loanwebportal.modelvo;

public class CollateralCashDepositsVO {
	private int collateralId;
	private int loanId; 
	private String ownerName;
	private String bankName;
	private long accountNumber;
	private double depositAmount;
	private double lockPeriod;
	
	public CollateralCashDepositsVO() {
	}
	
	public CollateralCashDepositsVO(int collateralId, int loanId, String ownerName, String bankName, long accountNumber,
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
		return "CollateralCashDepositsVO [collateralId=" + collateralId + ", loanId=" + loanId + ", ownerName="
				+ ownerName + ", bankName=" + bankName + ", accountNumber=" + accountNumber + ", depositAmount="
				+ depositAmount + ", lockPeriod=" + lockPeriod + "]";
	}
	
}
