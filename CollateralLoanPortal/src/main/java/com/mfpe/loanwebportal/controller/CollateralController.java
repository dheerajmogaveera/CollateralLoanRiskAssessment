package com.mfpe.loanwebportal.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfpe.loanwebportal.feign.CollateralClient;
import com.mfpe.loanwebportal.modelvo.CollateralCashDepositsVO;
import com.mfpe.loanwebportal.modelvo.CollateralRealEsatateVO;
import com.mfpe.loanwebportal.modelvo.CustomerLoanVO;
import com.mfpe.loanwebportal.service.CollateralDaoImpl;
import com.mfpe.loanwebportal.service.LoanInfoDao;

@Controller
public class CollateralController {
	@Autowired
	CollateralDaoImpl collateralDaoImpl;
	@Autowired
	LoanInfoDao loanInfoDao;
	@Autowired
	CollateralClient collateralClient;

	 
	
	static final Logger logger = LoggerFactory.getLogger(CollateralController.class);
	int loanId = 0;
	
	@GetMapping("/saveCollateral")
	public String saveCollateral(HttpServletRequest request) {
		logger.info("Getting the Loan Id for saving the collateral from user");
		if(request.getSession().getAttribute("login")!=null)
			return "SaveCollateralLandingPage";
		else
			return "redirect:/login";
	}
	
	@GetMapping("/saveCollateral/")
	public String saveCollateral(@RequestParam int loanId, HttpServletRequest request, ModelMap modelMap) {
		logger.info("Routing to designated page according to loanId");
			String token = "Bearer ";
			token += request.getSession().getAttribute("token");
			ResponseEntity<CustomerLoanVO> loanInfo = loanInfoDao.getLoanInfo(loanId, token);
				if(loanInfo.getBody().getType().equalsIgnoreCase("Real Estate")) {
					this.loanId = loanId;
					ResponseEntity<CollateralRealEsatateVO> byIdRealEstate = collateralClient.getByIdRealEstate(token, loanId);
					if(byIdRealEstate.getBody()==null) {
						return "SaveRealEstateCollateral";
					}
					else {
						modelMap.addAttribute("id", loanId);
						return "CollateralNotSaved";
						}
				}
				else {
					this.loanId = loanId;
					ResponseEntity<CollateralCashDepositsVO> byIdCashDeposit = collateralClient.getByIdCashDeposit(token, loanId);
					if(byIdCashDeposit.getBody()==null) {
						return "SaveCashDepositCollateral";
					}
					else {
						modelMap.addAttribute("id", loanId);
						return "CollateralNotSaved";
					}
				}

			}
			
		
		
	
	
	@PostMapping(value="/saveCollateral/realestate/" ,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String saveRealEstatesCollateral( CollateralRealEsatateVO collateral, /*@PathVariable int loanId @RequestParam int loanId,*/ ModelMap modelMap, HttpServletRequest request) {
			logger.info("Getting the Real Estate Collateral Info From user");
			collateral.setLoanId(loanId);
			String token = "Bearer ";
			token += request.getSession().getAttribute("token");
			collateralDaoImpl.saveRealEstateCollaterals(loanId, collateral, token);
			return "CollateralSaved";
		}
	
	@PostMapping(value="/saveCollateral/cashdeposit/" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String saveCashDepositCollateral(CollateralCashDepositsVO collateral /*@RequestParam int loanId*/, HttpServletRequest request) {
		logger.info("Getting the Cash Deposit Collateral Info From user");
		collateral.setLoanId(loanId);
		String token = "Bearer ";
		token += request.getSession().getAttribute("token");
		collateralDaoImpl.saveCashDepositCollaterals(loanId, collateral, token);
		return "CollateralSaved";
	}
}
