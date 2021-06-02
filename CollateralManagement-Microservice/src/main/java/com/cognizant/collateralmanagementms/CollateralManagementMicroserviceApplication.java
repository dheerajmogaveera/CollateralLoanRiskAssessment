package com.cognizant.collateralmanagementms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CollateralManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollateralManagementMicroserviceApplication.class, args);
	}

}
