package com.SimpleInMemDbWebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableRedisRepositories
@SpringBootApplication
public class SimpleInMemDbWebfluxDemoApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SimpleInMemDbWebfluxDemoApplication.class, args);
	}

}
