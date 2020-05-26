package com.reactiveDemo.config;

import com.reactiveDemo.handler.EmployeeRouterHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class EmployeeRouterConfig {
    @Bean
    RouterFunction<?> empRouterFunction(EmployeeRouterHandler routerHandlers) {

        return RouterFunctions.route(RequestPredicates.GET("/Employee"), routerHandlers::getAll)
                .andRoute(RequestPredicates.GET("/Employee/{id}"), routerHandlers::getId)
               .andRoute(RequestPredicates.POST(""),routerHandlers::creat);

    }
}
