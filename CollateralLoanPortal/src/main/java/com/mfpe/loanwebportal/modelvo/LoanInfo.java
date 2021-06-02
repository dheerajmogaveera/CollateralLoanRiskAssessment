package com.mfpe.loanwebportal.modelvo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class LoanInfo {
	private int loanId;
	private int customerId;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "LoanInfo [loanId=" + loanId + ", customerId=" + customerId + "]";
	}
	
}
