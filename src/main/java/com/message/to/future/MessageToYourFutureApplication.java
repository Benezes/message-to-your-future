package com.message.to.future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessageToYourFutureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageToYourFutureApplication.class, args);
	}

}
