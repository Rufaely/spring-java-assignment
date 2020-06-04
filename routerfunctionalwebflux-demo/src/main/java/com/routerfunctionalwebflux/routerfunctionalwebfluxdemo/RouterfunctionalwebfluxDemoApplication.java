package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
public class RouterfunctionalwebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouterfunctionalwebfluxDemoApplication.class, args);
    }
}
