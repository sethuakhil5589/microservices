package com.akhil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsQuizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsQuizServiceApplication.class, args);
	}

}
