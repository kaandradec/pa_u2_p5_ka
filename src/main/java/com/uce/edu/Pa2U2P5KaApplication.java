package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U2P5KaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nHOLA MUNDO! 12/12/2023\n");
	}
}
