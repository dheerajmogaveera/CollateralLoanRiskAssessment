package com.cognizant.collateralmanagementms.model;

public class AuthResponse {
	private String uid;
	private String uame;
	private boolean isValid;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUame() {
		return uame;
	}
	public void setUame(String uame) {
		this.uame = uame;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
