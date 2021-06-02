package com.mfpe.loanwebportal.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfpe.loanwebportal.modelvo.ErrorDetails;

import feign.FeignException;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FeignException.class)
	public ModelAndView handleFeignException(FeignException exception) throws JsonProcessingException {
		var mav = new ModelAndView();
		var json1 = exception.getMessage().split("]: ")[1].substring(1,exception.getMessage().split("]: ")[1].length() - 1);
		var om = new ObjectMapper();
		ErrorDetails er = om.readValue(json1, ErrorDetails.class);
		if(er.getMessage().contains("Wrong")) {
			mav.setViewName("LoginFailed");
			mav.addObject("err", er.getMessage());
			return mav;
		}
		mav.setViewName("Error");
		mav.addObject("err", er.getMessage());
		return mav;
		}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleFeignException()  {
		return new ModelAndView("Home");
		}
}