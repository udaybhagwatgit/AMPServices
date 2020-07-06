package com.ampservices.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableMongoRepositories("com.ampservices.mongorepositories")
@ComponentScan("com.ampservices")
@SpringBootApplication
@EnableAsync
public class AmpServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmpServiceProjectApplication.class, args);
	}

}
