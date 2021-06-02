package com.cognizant.collateralmanagementms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollateralRealEstate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collateral_id")
	private int collateralId;
	@Column(name = "loan_id")
	private int loanId;
	@Column(name = "owner_name")
	private String ownerName;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "area_in_ft")
	private int areaInFt;
	public CollateralRealEstate() {
		super();
	}
	public CollateralRealEstate(int collateralId, int loanId, String ownerName, String address, String city,
			String state, int areaInFt) {
		super();
		this.collateralId = collateralId;
		this.loanId = loanId;
		this.ownerName = ownerName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.areaInFt = areaInFt;
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
	@Override
	public String toString() {
		return "CollateralRealEstate [collateralId=" + collateralId + ", loanId=" + loanId + ", ownerName=" + ownerName
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", areaInFt=" + areaInFt + "]";
	}

	
}
