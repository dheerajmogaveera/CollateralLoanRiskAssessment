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
import com.mfpe.loanwebportal.service.LoanInfoDaoImpl;

@Controller

public class LoanController {
	@Autowired
	LoanInfoDaoImpl loanInfoDaoImpl;
	static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@GetMapping(value="/getLoanInfo")
	public String getLoanInfo(HttpServletRequest request) {
		logger.info("Getting the Loan Info from user");
		if(request.getSession().getAttribute("login")!=null)
			return "getLoan";
		else
			return "redirect:/login";
	
	}
	
	@GetMapping(value= "/getLoanInfo/result")
	public String showLoanInfo(@RequestParam int loanId, ModelMap modelMap ,HttpServletRequest request) {
		logger.info("Showing the Loan Information to the user");
		if(request.getSession().getAttribute("login")!=null)
		{
			var token = "Bearer ";
			token += request.getSession().getAttribute("token");
			ResponseEntity<CustomerLoanVO> loanInfo = loanInfoDaoImpl.getLoanInfo(loanId, token);
			CustomerLoanVO body = loanInfo.getBody();
			modelMap.addAttribute("Loan", body);
			modelMap.addAttribute("Customer", body.getCustomer());
			return "LoanResult";
		}
		else
			return "redirect:/login";
	}
}