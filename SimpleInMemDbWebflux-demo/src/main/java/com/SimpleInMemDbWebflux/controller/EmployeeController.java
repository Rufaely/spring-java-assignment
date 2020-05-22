package com.SimpleInMemDbWebflux.controller;


import com.SimpleInMemDbWebflux.model.Employee;
import com.SimpleInMemDbWebflux.repository.Impl.EmployeeRepoImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
@RestController
@RequestMapping(value = "/Employee")
public class EmployeeController {

    private final EmployeeRepoImpl employeeRepo;

    /**
     * @param employeeRepo
     */
    public EmployeeController(EmployeeRepoImpl employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /**
     * @return Flux<Employee>
     */
    @GetMapping(value = "/initial")
    public Flux<Employee> allInitial() {
        return this.employeeRepo.findAllInitial();
    }

    /**
     * @return Flux<Employee>
     */
    @GetMapping(value = "")
    public Flux<Employee> all() {
        return this.employeeRepo.findAll();
    }

    /**
     * @param id
     * @return Mono<Employee>
     */
    @GetMapping(value = "/{id}")
    public Mono<Employee> get(@PathVariable(value = "id") Long id) {
        return this.employeeRepo.findById(id);
    }

    /**
     * @param employee
     * @return Mono<Employee>
     */
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createPost(@RequestBody Employee employee) {
        return this.employeeRepo.createPost(employee);
    }

}
