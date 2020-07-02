package com.ampservices.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableMongoRepositories("com.ampservices.mongorepositories")
@ComponentScan("com.ampservices")
@SpringBootApplication
@EnableAsync
public class AmpServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmpServiceProjectApplication.class, args);
	}
	
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

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("AMP-Access-Control-Allow-Source-Origin")
						.exposedHeaders("AMP-Access-Control-Allow-Source-Origin")
						.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE").allowCredentials(true).maxAge(4800);
			}
		};
	}
}


}
