package com.backDev.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackApplication {

	public static void main(String[] args) {
		System.out.println("print test");
		SpringApplication.run(BackApplication.class, args);
	}

}
