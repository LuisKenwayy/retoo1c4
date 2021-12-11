package com.AppWillyWonka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication 
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.AppWillyWonka.Model"})
public class AppWillyWonkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWillyWonkaApplication.class, args);
	}

}
