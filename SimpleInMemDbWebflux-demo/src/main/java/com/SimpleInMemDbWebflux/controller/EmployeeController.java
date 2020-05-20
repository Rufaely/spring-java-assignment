package com.SimpleInMemDbWebflux.controller;


import com.SimpleInMemDbWebflux.model.Employee;
import com.SimpleInMemDbWebflux.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
    @RequestMapping(value = "/Employee")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping(value = "")
    public Flux<Employee> all() {
        return this.employeeRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Employee> get(@PathVariable(value = "id") Long id) {
        return this.employeeRepo.findById(id);
    }

    @PostMapping(value = "")
    public Mono<Employee> create(Employee employee) {
        return this.employeeRepo.createPost(employee);
    }

}
