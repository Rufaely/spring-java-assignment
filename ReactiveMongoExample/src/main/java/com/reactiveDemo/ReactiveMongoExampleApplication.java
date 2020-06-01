package com.reactiveDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * created by Rufael K yohannes
 */
@EnableMongoAuditing
@EnableReactiveMongoRepositories
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
