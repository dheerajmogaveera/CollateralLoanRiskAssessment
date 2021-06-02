package com.mfpe.loanwebportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CollateralLoanPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollateralLoanPortalApplication.class, args);
	}

}

