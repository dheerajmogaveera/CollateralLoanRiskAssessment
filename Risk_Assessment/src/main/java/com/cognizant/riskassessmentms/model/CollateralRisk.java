package com.cognizant.riskassessmentms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "collateral_risk")
public class CollateralRisk {

	@Id
	@Column(name = "risk_id")
	@GeneratedValue
	private int riskId;
	@Column(name = "name", length = 20)
	private String collateralType;
	@Column(name = "loan_id", length = 20)
	private int loanId;
	@Column(name = "collateral_id", length = 20)
	private int collateralId;
	@Column(name = "risk_percentage", length = 20)
	private double riskPercentage;
	@Column(name = "market_value", length = 20)
	private double marketValue;
	@Column(name = "is_loan_sanctioned", length = 20)
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
	
	
}
