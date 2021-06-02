package com.cognizant.loanmanagementms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoanManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementMicroserviceApplication.class, args);
	}

}
