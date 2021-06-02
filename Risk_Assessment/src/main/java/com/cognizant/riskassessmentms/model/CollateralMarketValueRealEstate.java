package com.cognizant.riskassessmentms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CollateralMarketValueRealEstate {
	@Id
	@Column(name = "market_id", length = 20)
	private int marketId;
	@Column(name = "city", length = 20)
	private String city;
	@Column(name = "state", length = 20)
	private String state;
	@Column(name = "rate_per_sqft", length = 20)
	private double ratePerSqft;
	public int getMarketId() {
		return marketId;
	}
	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getRatePerSqft() {
		return ratePerSqft;
	}
	public void setRatePerSqft(double ratePerSqft) {
		this.ratePerSqft = ratePerSqft;
	}
	
	
}
