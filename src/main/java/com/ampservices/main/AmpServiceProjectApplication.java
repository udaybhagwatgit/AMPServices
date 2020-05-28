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

}
