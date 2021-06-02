package com.mfpe.loanwebportal.modelvo;

public class RiskVO {
	private int riskId;
	private String collateralType;
	private int loanId;
	private int collateralId;
	private double riskPercentage;
	private double marketValue;
	private boolean isLoanSanctioned;
	
	public int getRiskId() {
		return riskId;
	}
	public void setRiskId(int riskId) {
		this.riskId = riskId;
	}
	public String getCollateralType() {
		return collateralType;
	}
	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getCollateralId() {
		return collateralId;
	}
	public void setCollateralId(int collateralId) {
		this.collateralId = collateralId;
	}
	public double getRiskPercentage() {
		return riskPercentage;
	}
	public void setRiskPercentage(double riskPercentage) {
		this.riskPercentage = riskPercentage;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	public boolean isLoanSanctioned() {
		return isLoanSanctioned;
	}
	
	public void setLoanSanctioned(boolean isLoanSanctioned) {
		this.isLoanSanctioned = isLoanSanctioned;
	}
	@Override
	public String toString() {
		return "RiskVO [riskId=" + riskId + ", collateralType=" + collateralType + ", loanId=" + loanId
				+ ", collateralId=" + collateralId + ", riskPercentage=" + riskPercentage + ", marketValue="
				+ marketValue + ", isLoanSanctioned=" + isLoanSanctioned + "]";
	}
}
