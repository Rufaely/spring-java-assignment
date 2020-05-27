package com.reactiveDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * created by Rufael K yohannes
 */
@EnableSwagger2
@SpringBootApplication
public class ReactiveMongoExampleApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoExampleApplication.class, args);
	}

}
