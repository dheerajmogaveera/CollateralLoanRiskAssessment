package com.mfpe.loanwebportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfpe.loanwebportal.modelvo.CustomerLoanVO;
import com.mfpe.loanwebportal.modelvo.RiskVO;
import com.mfpe.loanwebportal.service.LoanInfoDao;
import com.mfpe.loanwebportal.service.RiskDaoImpl;

@Controller
public class RiskController {
	
	@Autowired
	RiskDaoImpl riskDaoImpl;
	@Autowired
	LoanInfoDao loanInfoDao;
	static final Logger logger = LoggerFactory.getLogger(RiskController.class);
	
	@GetMapping(value= "/getRiskOfCollateral")
	public String getCollateralRisk(HttpServletRequest request) {
		logger.info("Asking the loanId from the user to calculate risk");
		if(request.getSession().getAttribute("login")!=null)
			return "RiskAssessment";
		else
			return "redirect:/login";
		
	}
	
	@GetMapping(value= "/getRiskOfCollateral/status")
	public String getCollateralRiskResult(@RequestParam int loanId, ModelMap modelMap, HttpServletRequest request) {
		logger.info("Showing the risk assessment result page to the user");
		var token = "Bearer ";
		var status = "status";
		var result="";
		token += request.getSession().getAttribute("token");
		if(request.getSession().getAttribute("login")!=null)
		{
		
			ResponseEntity<CustomerLoanVO> loanInfo = loanInfoDao.getLoanInfo(loanId, token);
			if(loanInfo.getBody().getType().equals("Real Estate")) {
					ResponseEntity<RiskVO> realEstateCollateralRisk = riskDaoImpl.getRealEstateCollateralRisk(loanId, token);
					result = (realEstateCollateralRisk.getBody().isLoanSanctioned())?"Sanctioned":"Not Sanctioned";
					modelMap.addAttribute("risk", realEstateCollateralRisk.getBody());
					modelMap.addAttribute("status", result);
					return "AssessmentResult";
				
			}
			
			else {
					ResponseEntity<RiskVO> cashDepositCollateralRisk = riskDaoImpl.getCashDepositCollateralRisk(loanId, token);
					result = (cashDepositCollateralRisk.getBody().isLoanSanctioned())?"Sanctioned":"Not Sanctioned"; 
					modelMap.addAttribute("risk", cashDepositCollateralRisk.getBody());
					modelMap.addAttribute(status, result);
					return "AssessmentResult";
						
				}
	}
	else
		return "redirect:/login";
	}	

}