package com.reactiveDemo.config;

import com.reactiveDemo.handler.RouterHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

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

        return RouterFunctions.route(RequestPredicates.GET("/Department"), routerHandlers::getAllDep)
                .andRoute(RequestPredicates.GET("/Department/{id}"), routerHandlers::getDepById)
                .andRoute(RequestPredicates.DELETE("/Department"), routerHandlers::deleteDep)
//                .andRoute(RequestPredicates.POST("/Department"), routerHandlers::createDep)

                .andRoute(RequestPredicates.GET("/Employee"), routerHandlers::getAllEmp)
                .andRoute(RequestPredicates.GET("/Employee/{id}"), routerHandlers::getEmpById)
                .andRoute(RequestPredicates.DELETE("/Employee"), routerHandlers::deleteEmp)
//                .andRoute(RequestPredicates.POST("/Employee"),routerHandlers::creatEmp);
                ;
    }

}
