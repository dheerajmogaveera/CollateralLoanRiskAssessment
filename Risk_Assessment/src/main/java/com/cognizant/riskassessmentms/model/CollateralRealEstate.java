package com.cognizant.riskassessmentms.model;

public class CollateralRealEstate {
	private int collateralId;

	private int loanId;
	private String ownerName;
	private String address;
	private String city;
	private String state;
	private int areaInFt;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getAreaInFt() {
		return areaInFt;
	}
	public void setAreaInFt(int areaInFt) {
		this.areaInFt = areaInFt;
	}
	
	
}
