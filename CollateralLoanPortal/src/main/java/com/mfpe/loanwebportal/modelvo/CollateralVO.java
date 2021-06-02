package com.mfpe.loanwebportal.modelvo;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CollateralVO {
	private int loanId;
	private int collateralId;
	private long collateralValue;
	private LocalDateTime pledgedDate;
	
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
	public long getCollateralValue() {
		return collateralValue;
	}
	public void setCollateralValue(long collateralValue) {
		this.collateralValue = collateralValue;
	}
	public LocalDateTime getPledgedDate() {
		return pledgedDate;
	}
	public void setPledgedDate(LocalDateTime pledgedDate) {
		this.pledgedDate = pledgedDate;
	}
	@Override
	public String toString() {
		return "CollateralVO [loanId=" + loanId + ", collateralId=" + collateralId + ", collateralValue="
				+ collateralValue + ", pledgedDate=" + pledgedDate + "]";
	}
}
