package com.reactiveDemo.service.impl;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@DataMongoTest
@Import(DepartmentServiceImp.class)
class DepartmentServiceImpTest {

    private final DepartmentServiceImp departmentServiceImp;
    private final DepartmentRepo departmentRepo;

    Employee employee = new Employee();
    Department department = new Department();
    List<Employee> employees = new ArrayList<>();

    DepartmentServiceImpTest(@Autowired DepartmentServiceImp departmentServiceImp, @Autowired DepartmentRepo departmentRepo) {
        this.departmentServiceImp = departmentServiceImp;
        this.departmentRepo = departmentRepo;
    }

    @BeforeEach
    void setUp() {
        employee.setFirstName("Rufael");
        employee.setLastName("kidanemariam");
        employees.add(employee);
        department.setEmployees(employees);
        department.setName("Finance");
    }

    @Test
    void all() {
        Flux<Department> departmentFlux = departmentRepo.saveAll(Flux.just(
                department, department, department));
        Flux<Department> departmentFlux1 = departmentServiceImp.all().thenMany(departmentFlux);
        Predicate<Department> predicate = dep -> departmentFlux.any(saveItem -> saveItem.equals(dep)).block();
        StepVerifier
                .create(departmentFlux1)
                .expectNextMatches(predicate)
                .expectNextMatches(predicate)
                .expectNextMatches(predicate)
                .verifyComplete();
    }

    @Test
    void get() {

        Mono<Department> departmentMono = this.departmentServiceImp
                .createDep(department)
                .flatMap(saved -> this.departmentServiceImp.get(saved.getId()));
        StepVerifier
                .create(departmentMono)
                .expectNextMatches(dep -> !dep.getId().equals(null))
//                .expectNextMatches(dep-> dep.getName().equals("Finance"))
//                .expectNextMatches(dep->dep.getEmployees().get(0).getFirstName().equals("Rufael"))
//                .expectNextMatches(dep->dep.getEmployees().get(0).getLastName().equals("kidanemariam"))

                .verifyComplete();
    }

    @Test
    void createDep() {
        Mono<Department> departmentMono = this.departmentServiceImp.createDep(department);
        StepVerifier
                .create(departmentMono)
                .expectNextMatches(saved -> StringUtils.hasText(saved.getId()))
                .verifyComplete();
    }

    @Test
    void delete() {
        Mono<Department> deleted = this.departmentServiceImp
                .createDep(department)
                .flatMap(saved -> this.departmentServiceImp.deleteDep(saved.getId()));
        StepVerifier
                .create(deleted)
                .expectNextMatches(dep -> dep.getName().equalsIgnoreCase("Finance"))
                .verifyComplete();
    }
}