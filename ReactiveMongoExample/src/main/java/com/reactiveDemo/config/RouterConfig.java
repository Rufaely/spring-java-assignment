package com.reactiveDemo.config;

import com.reactiveDemo.handler.RouterHandler;
import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

/**
 * created by Rufael K yohannes
 */
@Configuration
public class RouterConfig {
    /**
     * @param routerHandlers
     * @return RouterFunction<?>
     */
    @Bean
    RouterFunction<?> depRouterFunction(RouterHandler routerHandlers) {

        return RouterFunctions.route(RequestPredicates.GET("/router/Department")
                .and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getAllDep)
                .andRoute(RequestPredicates.GET("/router/Department/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getDepById)
                .andRoute(RequestPredicates.DELETE("/router/Department"), routerHandlers::deleteDep)
                .andRoute(RequestPredicates.POST("/router/Department")
                        .and(accept(MediaType.APPLICATION_JSON)).and(contentType(MediaType.APPLICATION_JSON)), serverRequest -> {
                    Mono<ServerResponse> dep = routerHandlers.createDep(serverRequest,new Department());
                    return dep;
                })

                .andRoute(RequestPredicates.GET("/router/Employee")
                        .and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getAllEmp)
                .andRoute(RequestPredicates.GET("/router/Employee/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getEmpById)
                .andRoute(RequestPredicates.DELETE("/router/Employee"), routerHandlers::deleteEmp)
                .andRoute(RequestPredicates.POST("/router/Employee")
                        .and(accept(MediaType.APPLICATION_JSON)).and(contentType(MediaType.APPLICATION_JSON)), serverRequest -> {
                    Mono<ServerResponse> emp = routerHandlers.createEmp(serverRequest,new Employee());
                    return emp;
                });
    }

}
