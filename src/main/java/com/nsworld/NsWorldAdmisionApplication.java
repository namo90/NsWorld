package com.nsworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NsWorldAdmisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(NsWorldAdmisionApplication.class, args);
	}

}
