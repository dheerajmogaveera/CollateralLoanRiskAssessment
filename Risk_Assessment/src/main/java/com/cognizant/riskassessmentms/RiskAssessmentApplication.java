package com.cognizant.riskassessmentms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class RiskAssessmentApplication {

	private static final Logger logger = LoggerFactory.getLogger(RiskAssessmentApplication.class);

	public static void main(String[] args) {

		logger.warn("Risk Assessment Application has started working");
		SpringApplication.run(RiskAssessmentApplication.class, args);
	}

}
