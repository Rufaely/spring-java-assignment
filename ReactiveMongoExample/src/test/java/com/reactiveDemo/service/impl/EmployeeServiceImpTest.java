package com.reactiveDemo.service.impl;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.function.Predicate;

@DataMongoTest
@Import(EmployeeServiceImp.class)
class EmployeeServiceImpTest {
    private final EmployeeServiceImp employeeServiceImp;
    private final EmployeeRepo employeeRepo;
    Employee employee = new Employee();

    EmployeeServiceImpTest(@Autowired EmployeeServiceImp employeeServiceImp, @Autowired EmployeeRepo employeeRepo) {
        this.employeeServiceImp = employeeServiceImp;
        this.employeeRepo = employeeRepo;
    }

    @BeforeEach
    void setUp() {
        employee.setFirstName("Rufael");
        employee.setLastName("Yohannes");
    }

    @Test
    void all() {
        Flux<Employee> employeeFlux = employeeRepo.saveAll(Flux.just(
                employee,employee,employee));
        Flux<Employee> employeeFlux1 = employeeServiceImp.all().thenMany(employeeFlux);
        Predicate<Employee> predicate = emp -> employeeFlux.any(saveItem -> saveItem.equals(emp)).block();
        StepVerifier
                .create(employeeFlux1)
                .expectNextMatches(predicate)
                .expectNextMatches(predicate)
                .expectNextMatches(predicate)
                .verifyComplete();
    }

    @Test
    void get() {
        Mono<Employee> employeeMono = this.employeeServiceImp
                .createEmp(employee)
                .flatMap(saved -> this.employeeServiceImp.get(saved.getId()));
        StepVerifier
                .create(employeeMono)
                .expectNextMatches(dep -> !dep.getId().equals(null))
//                .expectNextMatches(dep-> dep.getFirstName().equals("Rufael"))
//                .expectNextMatches(dep->dep.getLastName().equals("Yohannes"))

                .verifyComplete();
    }

    @Test
    void createEmp() {
        Mono<Employee> employeeMono = this.employeeServiceImp.createEmp(employee);
        StepVerifier
                .create(employeeMono)
                .expectNextMatches(saved -> StringUtils.hasText(saved.getId()))
                .verifyComplete();
    }

    @Test
    void delete() {
        Mono<Employee> deleted = this.employeeServiceImp
                .createEmp(employee)
                .flatMap(saved -> this.employeeServiceImp.delete(saved.getId()));
        StepVerifier
                .create(deleted)
                .expectNextMatches(dep -> dep.getFirstName().equalsIgnoreCase("Rufael"))
//                .expectNextMatches(dep -> dep.getLastName().equalsIgnoreCase("Yohannes"))
                .verifyComplete();
    }
}