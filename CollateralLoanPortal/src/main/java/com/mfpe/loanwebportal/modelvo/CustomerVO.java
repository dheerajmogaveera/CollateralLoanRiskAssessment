package com.mfpe.loanwebportal.modelvo;


public class CustomerVO {
	private int customerId;
	private String customerName;
	private CustomerLoanVO customerLoan;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public CustomerLoanVO getCustomerLoan() {
		return customerLoan;
	}
	public void setCustomerLoan(CustomerLoanVO customerLoan) {
		this.customerLoan = customerLoan;
	}
	@Override
	public String toString() {
		return "CustomerVO [customerId=" + customerId + ", customerName=" + customerName + ", customerLoan="
				+ customerLoan + "]";
	}
}
