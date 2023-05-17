package com.mistertransfer.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.mistertransfer","com.bookinadvance"})
@SpringBootApplication
public class MrtReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrtReportsApplication.class, args);
	}

}
