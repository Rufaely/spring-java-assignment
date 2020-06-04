package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.handler;


import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Department;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Employee;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.DepartmentService;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.validation.Validator;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * created by Rufael K yohannes
 */
@Component
public class RouterHandler {


    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    /**
     * @param departmentService
     * @param employeeService
     */
    public RouterHandler(@Autowired DepartmentService departmentService, @Autowired EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }


    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getAllDep(ServerRequest serverRequest) {
        Flux<Department> departmentFlux = departmentService.getAllDepartments();
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(departmentFlux, Department.class);
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getDepById(ServerRequest serverRequest) {
        String depId = serverRequest.pathVariable("id");
        Mono<Department> departmentMono = departmentService.getDepartment(depId);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return departmentMono
                .flatMap(dep ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(fromObject(dep)))
                .switchIfEmpty(notFound);
    }

    /**
     * @param serverRequest
     * @param department
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> createDep(ServerRequest serverRequest, Department department) {
        Mono<Department> departmentMono = serverRequest.bodyToMono(Department.class);

        return departmentMono.flatMap(dep ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(departmentService.createDepartment(dep), Department.class));
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> deleteDep(ServerRequest serverRequest) {
        String depId = serverRequest.pathVariable("id");
        Mono<Department> departmentMono = departmentService.deleteDepartment(depId);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(departmentMono, Department.class)
                .switchIfEmpty(notFound);
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getAllEmp(ServerRequest serverRequest) {
        Flux<Employee> employeeFlux = employeeService.getAllEmployees();

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(employeeFlux, Employee.class);
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getEmpById(ServerRequest serverRequest) {

        String depId = serverRequest.pathVariable("id");
        Mono<Employee> employeeMono = employeeService.getEmployee(depId);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return employeeMono
                .flatMap(emp -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(emp)))
                .switchIfEmpty(notFound);
    }


    /**
     * @param serverRequest
     * @param employee
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> createEmp(ServerRequest serverRequest, Employee employee) {
        Mono<Employee> employeeMono = serverRequest.bodyToMono(Employee.class);

        return employeeMono.flatMap(emp ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(APPLICATION_JSON)
                        .body(employeeService.createEmployee(emp), Employee.class));
    }


    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> deleteEmp(ServerRequest serverRequest) {
        String empId = serverRequest.pathVariable("id");
        Mono<Employee> employeeMono = employeeService.deleteEmployee(empId);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(employeeMono, Employee.class)
                .switchIfEmpty(notFound);
    }
}