package com.cognizant.riskassessmentms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CollateralMarketValueCashDeposits {
	@Id
	@Column(name = "market_id", length = 20)
	private int marketId;
	@Column(name = "bank_name", length = 20)
	private String bankName;
	@Column(name = "interest_rate", length = 20)
	private double interestRate;
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}
