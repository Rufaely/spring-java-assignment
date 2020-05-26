package com.reactiveDemo;

import com.reactiveDemo.repository.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveMongoExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoExampleApplication.class, args);
	}

}
