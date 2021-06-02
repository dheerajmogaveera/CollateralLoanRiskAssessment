package com.cognizant.riskassessmentms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.riskassessmentms.client.CollateralClient;
import com.cognizant.riskassessmentms.client.CustomerLoanClient;
import com.cognizant.riskassessmentms.dao.RiskAssessmentDao;
import com.cognizant.riskassessmentms.exception.CollateralNotFoundException;
import com.cognizant.riskassessmentms.exception.CustomerLoanNotFoundException;
import com.cognizant.riskassessmentms.model.CollateralCashDeposit;
import com.cognizant.riskassessmentms.model.CollateralMarketValueCashDeposits;
import com.cognizant.riskassessmentms.model.CollateralMarketValueRealEstate;
import com.cognizant.riskassessmentms.model.CollateralRealEstate;
import com.cognizant.riskassessmentms.model.CollateralRisk;
import com.cognizant.riskassessmentms.model.CustomerLoan;
import com.cognizant.riskassessmentms.repository.CollateralMarketValueCashDepositRepository;
import com.cognizant.riskassessmentms.repository.CollateralMarketValueRealEstateRepository;
import com.cognizant.riskassessmentms.repository.CollateralRiskRepository;



@Service
public class RiskAssessmentImpl implements RiskAssessmentDao {

	@Autowired
	private CollateralClient collateralfeignclient;
	@Autowired
	private CustomerLoanClient loanClient;
	
	
	@Autowired
	private CollateralRiskRepository riskAssessmentRepository;

	@Autowired
	private CollateralMarketValueRealEstateRepository realEstateRepository;

	@Autowired
	private CollateralMarketValueCashDepositRepository cashDepositsRepository;
	
	
	public CollateralRisk getRiskForRealEstate(String token, int loanId) {
		
		CollateralRealEstate collateralRealEstate;

		CustomerLoan loan;
		double currentValue = 0;
		double marketValue = 0;
		CollateralMarketValueRealEstate marketValueRealEstate;
		
		collateralRealEstate = collateralfeignclient.getByIdRealEstate(token,loanId).getBody();
		if(collateralRealEstate==null) {
			throw new CollateralNotFoundException("No Collateral for loan ID: "+loanId+" found");
		}
		
		loan = loanClient.getById(loanId ,token).getBody();
		if(loan==null)
			throw new CustomerLoanNotFoundException("No Customer with loan ID "+loanId+" found");
		else {
			currentValue = calculateCurrentValue(loan.getLoanPrincipal(), loan.getInterest(), loan.getTenureYear());
		}

		if (collateralRealEstate != null) {
			marketValueRealEstate = realEstateRepository.findByCityAndState(collateralRealEstate.getCity(),
					collateralRealEstate.getState());
			marketValue = marketValueRealEstate.getRatePerSqft() * collateralRealEstate.getAreaInFt();
		}
		
		double riskPercentage = Math.round(calculateRiskPercentage(marketValue, currentValue));
		Optional<CollateralRisk> optionalCollateralRisk = riskAssessmentRepository.findByLoanIdAndCollateralType(loanId,
				"Real Estate");
		if (optionalCollateralRisk.isPresent()) {
			return optionalCollateralRisk.get();
		}else {
			
			CollateralRisk newCollateralRisk = new CollateralRisk();
			newCollateralRisk.setCollateralType("Real Estate");
			newCollateralRisk.setLoanId(loanId);
			newCollateralRisk.setRiskPercentage(riskPercentage);
			newCollateralRisk.setMarketValue(marketValue);
			newCollateralRisk.setCollateralId(collateralRealEstate.getCollateralId());
			newCollateralRisk.setLoanSanctioned(isLoanSanctioned(riskPercentage));
			return riskAssessmentRepository.save(newCollateralRisk);
		}	

	}

	
	public CollateralRisk getRiskForCashDeposits(String token, int loanId){

		CollateralCashDeposit collateralCashDeposits;

		CustomerLoan loan;
		double currentValue = 0;
		double marketValue = 0;
		CollateralMarketValueCashDeposits marketValueCashDeposits;

		collateralCashDeposits = collateralfeignclient.getByIdCashDeposit(token,loanId).getBody();
		if(collateralCashDeposits==null) {
			throw new CollateralNotFoundException("No collateral for loan ID: "+loanId+" found");
		}
		
	
			loan = loanClient.getById(loanId , token).getBody();
		if(loan==null)
			throw new CustomerLoanNotFoundException("No loan for loan ID: "+loanId+" found");
		else {
			currentValue = calculateCurrentValue(loan.getLoanPrincipal(), loan.getInterest(), loan.getTenureYear());
		}
		
		if (collateralCashDeposits != null) {
			System.out.println(collateralCashDeposits.getBankName());
			marketValueCashDeposits = cashDepositsRepository.findByBankName(collateralCashDeposits.getBankName());
			marketValue = collateralCashDeposits.getDepositAmount() + ((marketValueCashDeposits.getInterestRate()
					* collateralCashDeposits.getDepositAmount() * collateralCashDeposits.getLockPeriod()) / 100);
		}

		double riskPercentage = calculateRiskPercentage(marketValue, currentValue);
		Optional<CollateralRisk> optionalCollateralRisk = riskAssessmentRepository.findByLoanIdAndCollateralType(loanId,
				"Cash Deposits");
		if (optionalCollateralRisk.isPresent()) {

			return optionalCollateralRisk.get();
		}

		CollateralRisk newCollateralRiskCashDeposits = new CollateralRisk();
		newCollateralRiskCashDeposits.setCollateralType("Cash Deposits");
		newCollateralRiskCashDeposits.setLoanId(loanId);
		newCollateralRiskCashDeposits.setRiskPercentage(riskPercentage);
		newCollateralRiskCashDeposits.setMarketValue(marketValue);
		newCollateralRiskCashDeposits.setCollateralId(collateralCashDeposits.getCollateralId());
		newCollateralRiskCashDeposits.setLoanSanctioned(isLoanSanctioned(riskPercentage));
		return riskAssessmentRepository.save(newCollateralRiskCashDeposits);

	}
	

	public double calculateRiskPercentage(double marketValue, double currentValue) {

		double riskFactor = (marketValue / currentValue);
		if (riskFactor >= 1.0) {
						return 0;
		} else {
			if (riskFactor > 0.5 && riskFactor < 1.0) {
				return (100 - (riskFactor * 100));
			} else {
				return 100;
			}
		}
	}
	
	

	public double calculateCurrentValue(double loanPrincipal, double interest, int tenureYear) {

		return loanPrincipal + (loanPrincipal * interest * tenureYear)/100;

	}
	
	
	
	public boolean isLoanSanctioned(double riskPercentage) {
		boolean status = false;
		if(riskPercentage >= 0 && riskPercentage <= 50) 
			status= true;
		return status;
	}
}