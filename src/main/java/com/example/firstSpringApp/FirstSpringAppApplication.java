package com.example.firstSpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FirstSpringAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}
}
