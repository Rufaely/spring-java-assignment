package com.reactiveDemo.config;

import com.reactiveDemo.handler.DepartmentRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class DepartmentRouterConfig {
    @Bean
    RouterFunction<?> depRouterFunction(DepartmentRouterHandler routerHandlers) {

        return RouterFunctions.route(RequestPredicates.GET("/Department"), routerHandlers::getAll)
                .andRoute(RequestPredicates.GET("/Department/{id}"), routerHandlers::getId)
                .andRoute(RequestPredicates.POST(""), routerHandlers::create);

    }


}
