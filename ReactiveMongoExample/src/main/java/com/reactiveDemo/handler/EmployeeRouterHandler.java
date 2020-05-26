package com.reactiveDemo.handler;
import com.reactiveDemo.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import com.reactiveDemo.repository.EmployeeRepo;

@Component
public class EmployeeRouterHandler {
    private EmployeeRepo employeeRepo;

    public EmployeeRouterHandler(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .body(employeeRepo.findAll(), Employee.class);
    }

    public Mono<ServerResponse> getId(ServerRequest serverRequest) {

        String empId = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .body(employeeRepo.findById(empId), Employee.class);
    }


    public Mono<ServerResponse> creat(ServerRequest serverRequest) {
        return null;
    }
}
