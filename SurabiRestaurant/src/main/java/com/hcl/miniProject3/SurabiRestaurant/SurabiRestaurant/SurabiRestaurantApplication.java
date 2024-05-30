package com.hcl.miniProject3.SurabiRestaurant.SurabiRestaurant;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class SurabiRestaurantApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SurabiRestaurantApplication.class, args);
		System.out.println("Hello Spring Boot App");
	}

}
