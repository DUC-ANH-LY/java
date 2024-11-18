package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
		scanBasePackages = {"com.luv2code.springcoredemo",
							"com.luv2code.util"})

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
//		CricketCoach myCoach = new CricketCoach();
		System.out.println(myCoach.test());
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
