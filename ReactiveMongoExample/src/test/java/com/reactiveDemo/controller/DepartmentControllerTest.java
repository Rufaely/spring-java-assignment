package com.reactiveDemo.controller;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
class DepartmentControllerTest {
    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    WebTestClient webTestClient;
    Employee employee;
    Department department;
    List<Employee> employees;

    @BeforeEach
    void setUp() {
        employee.setFirstName("Rufael");
        employee.setLastName("kidanemariam");
        employees.add(employee);
        department.setName("Finance");
        department.setEmployees(employees);
    }

    @Test
    void all() {
        /*webTestClient.get()
                .uri("/Department")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();*/
    }

    @Test
    void get() {
    }

    @Test
    void createDep() {
        /*Flux<Department> savedDep = Flux.just(department)
                .flatMap(d -> this.departmentService.createDep(d));

        Flux<Department> interval = this.reactiveMongoTemplate
                .dropCollection(Department.class)
                .thenMany(savedDep)
                .thenMany(this.departmentService.all());


    Predicate<Department> departmentPredicate = department1 ->
            department1.getEmployees().equals(department.getEmployees())
                    && department1.getName().equalsIgnoreCase(department.getName())
                    && department1.getId().equalsIgnoreCase(department.getId());
    StepVerifier
            .create(interval)
            .expectNextMatches(departmentPredicate)
            .verifyComplete();*/

    }

    @Test
    void delete() {
    }
}