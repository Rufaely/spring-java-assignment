package com.reactiveDemo.handler;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.repository.DepartmentRepo;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DepartmentRouterHandler {
    private DepartmentRepo departmentRepo;

    public DepartmentRouterHandler(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .body(departmentRepo.findAll(), Department.class);
    }

    public Mono<ServerResponse> getId(ServerRequest serverRequest) {

        String depId = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .body(departmentRepo.findById(depId), Department.class);
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return null;
    }

}
