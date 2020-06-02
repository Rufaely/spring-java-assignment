package com.reactiveDemo.handler;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.DepartmentRepo;
import com.reactiveDemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * created by Rufael K yohannes
 */
@Component
public class RouterHandler {

    private  final DepartmentRepo departmentRepo;
    private  final EmployeeRepo employeeRepo;

    /**
     * @param departmentRepo
     * @param employeeRepo
     */
    public RouterHandler(@Autowired DepartmentRepo departmentRepo, @Autowired EmployeeRepo employeeRepo) {
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
    }



    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getAllDep(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .body(departmentRepo.findAll(), Department.class);
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getDepById(ServerRequest serverRequest) {

        String depId = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .body(departmentRepo.findById(depId), Department.class);
    }

    /**
     * @param serverRequest
     * @param department
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> createDep(ServerRequest serverRequest, Department department) {
        Employee newEmp = new Employee();

        Department newDep = new Department();
        newDep.setName(department.getName());
        return ServerResponse
                .ok()
                .body(departmentRepo.save(newDep), Department.class);
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> deleteDep(ServerRequest serverRequest) {
        String depId = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .body(departmentRepo.deleteById(depId), Department.class);
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getAllEmp(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .body(employeeRepo.findAll(), Employee.class);
    }

    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> getEmpById(ServerRequest serverRequest) {

        String empId = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .body(employeeRepo.findById(empId), Employee.class);
    }


    /**
     * @param serverRequest
     * @param employee
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> createEmp(ServerRequest serverRequest, Employee employee) {
        Employee newEmp = new Employee();
        newEmp.setFirstName(employee.getFirstName());
        newEmp.setLastName(employee.getLastName());
        return ServerResponse
                .ok()
                .body(employeeRepo.save(newEmp), Employee.class);
    }


    /**
     * @param serverRequest
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> deleteEmp(ServerRequest serverRequest) {
        String empId = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .body(employeeRepo.deleteById(empId), Employee.class);
    }
}