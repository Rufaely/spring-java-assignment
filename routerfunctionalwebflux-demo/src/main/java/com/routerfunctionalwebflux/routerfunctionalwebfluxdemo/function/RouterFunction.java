package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.function;

import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.handler.RouterHandler;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Department;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MyRouterFunction {
    @Bean
    org.springframework.web.reactive.function.server.RouterFunction<ServerResponse> DepartmentRoute(RouterHandler routerHandlers) {


//        return route(GET("/Department").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getAllDep)
//                .andRoute(GET("/Department/{id}").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getDepById)
//                .andRoute(DELETE("/Department/{id}"), routerHandlers::deleteDep)
//                .andRoute(POST("/Department").and(accept(MediaType.APPLICATION_JSON)).
//                        and(contentType(MediaType.APPLICATION_JSON)), serverRequest -> {
//                    Mono<ServerResponse> dep = routerHandlers.createDep(serverRequest, new Department());
//                    return dep;
//                })
//                .andRoute(GET("/Employee").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getAllEmp)
//                .andRoute(GET("/Employee/{id}").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getEmpById)
//                .andRoute(DELETE("/Employee/{id}"), routerHandlers::deleteEmp)
//                .andRoute(POST("/Employee").and(accept(MediaType.APPLICATION_JSON)).
//                        and(contentType(MediaType.APPLICATION_JSON)), serverRequest -> {
//                    Mono<ServerResponse> emp = routerHandlers.createEmp(serverRequest, new Employee());
//                    return emp;
//                });
        return  route().path("/Department", builder -> builder
                .POST("", accept(MediaType.APPLICATION_JSON),request -> {
                    Mono<ServerResponse> departmentMono = routerHandlers.createDep(request,new Department());
                    return departmentMono;
                })
                .GET("{id}", accept(MediaType.APPLICATION_JSON), routerHandlers::getDepById)
                .GET("", accept(MediaType.APPLICATION_JSON), routerHandlers::getAllDep)
                .DELETE("{id}", accept(MediaType.APPLICATION_JSON), routerHandlers::deleteDep))
                .build();

    }

        @Bean
        org.springframework.web.reactive.function.server.RouterFunction<ServerResponse> EmployeeRoute(RouterHandler routerHandlers) {


//        return route(GET("/Department").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getAllDep)
//                .andRoute(GET("/Department/{id}").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getDepById)
//                .andRoute(DELETE("/Department/{id}"), routerHandlers::deleteDep)
//                .andRoute(POST("/Department").and(accept(MediaType.APPLICATION_JSON)).
//                        and(contentType(MediaType.APPLICATION_JSON)), serverRequest -> {
//                    Mono<ServerResponse> dep = routerHandlers.createDep(serverRequest, new Department());
//                    return dep;
//                })
//                .andRoute(GET("/Employee").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getAllEmp)
//                .andRoute(GET("/Employee/{id}").and(accept(MediaType.APPLICATION_JSON)), routerHandlers::getEmpById)
//                .andRoute(DELETE("/Employee/{id}"), routerHandlers::deleteEmp)
//                .andRoute(POST("/Employee").and(accept(MediaType.APPLICATION_JSON)).
//                        and(contentType(MediaType.APPLICATION_JSON)), serverRequest -> {
//                    Mono<ServerResponse> emp = routerHandlers.createEmp(serverRequest, new Employee());
//                    return emp;
//                });
        return  route().path("/Employee", builder -> builder
                .POST("", accept(MediaType.APPLICATION_JSON),request -> {
                    Mono<ServerResponse>  employeemono = routerHandlers.createEmp(request,new Employee());
                    return employeemono;
                })
                .GET("{id}", accept(MediaType.APPLICATION_JSON), routerHandlers::getEmpById)
                .GET("", accept(MediaType.APPLICATION_JSON), routerHandlers::getAllEmp)
                .DELETE("{id}", accept(MediaType.APPLICATION_JSON),routerHandlers::deleteEmp))
                .build();

    }

}
