package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.impl;

import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Employee;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.repository.EmployeeRepo;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Import(EmployeeServiceImp.class)
class EmployeeServiceImpTest {
    private final EmployeeServiceImp employeeServiceImp;
    private final EmployeeRepo employeeRepo;
    Employee employee = new Employee();
    List<Employee> employees = new ArrayList<>();

    EmployeeServiceImpTest(@Autowired EmployeeServiceImp employeeServiceImp, @Autowired EmployeeRepo employeeRepo) {
        this.employeeServiceImp = employeeServiceImp;
        this.employeeRepo = employeeRepo;
    }
    @Test
    public void contexLoads() throws Exception {
        assertThat(employeeServiceImp).isNotNull();
    }
    @BeforeEach
    void setUp() {
        employee.setFirstName("Rufael");
        employee.setLastName("Yohannes");
    }

    @Test
    void testGetAllEmployees() {
        Flux<Employee> employeeFlux = employeeRepo.saveAll(Flux.just(
                employee, employee, employee));
        Flux<Employee> employeeFlux1 = employeeServiceImp.getAllEmployees().thenMany(employeeFlux);
        Predicate<Employee> predicate = emp -> employeeFlux.any(saveItem -> saveItem.equals(emp)).block();
        StepVerifier
                .create(employeeFlux1)
                .expectNextMatches(predicate)
                .expectNextMatches(predicate)
                .expectNextMatches(predicate)
                .verifyComplete();
    }

    @Test
    void testGetEmployee() {
        Mono<Employee> employeeMono = this.employeeServiceImp
                .createEmployee(employee)
                .flatMap(saved -> this.employeeServiceImp.getEmployee(saved.getId()));
        StepVerifier
                .create(employeeMono)
                .expectNextMatches(dep -> !dep.getId().equals(null))
//                .expectNextMatches(dep-> dep.getFirstName().equals("Rufael"))
//                .expectNextMatches(dep->dep.getLastName().equals("Yohannes"))

                .verifyComplete();
    }

    @Test
    void testCreateEmployee() {
        Mono<Employee> employeeMono = this.employeeServiceImp.createEmployee(employee);
        StepVerifier
                .create(employeeMono)
                .expectNextMatches(saved -> StringUtils.hasText(saved.getId()))
                .verifyComplete();
    }

    @Test
    void testDeleteEmployee() {
        Mono<Employee> deleted = this.employeeServiceImp
                .createEmployee(employee)
                .flatMap(saved -> this.employeeServiceImp.deleteEmployee(saved.getId()));
        StepVerifier
                .create(deleted)
                .expectNextMatches(dep -> dep.getFirstName().equalsIgnoreCase("Rufael"))
//                .expectNextMatches(dep -> dep.getLastName().equalsIgnoreCase("Yohannes"))
                .verifyComplete();
    }

   /* @Test
    void testDeleteAllEmployees() {
        Flux<Employee> employeeFlux = employeeRepo.saveAll(Flux.just(
                employee, employee, employee));
        Flux<Employee> deleted = this.employeeServiceImp.deleteAllEmployees();
        StepVerifier
                .create(employeeFlux)
                .expectNextMatches(emp -> emp.equals(deleted))
                .verifyComplete();
    }
*/
}
