
package com.reactiveDemo.controller;

import com.reactiveDemo.model.Employee;
import com.reactiveDemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *created by Rufael K yohannes
 */
@RestController
@RequestMapping(value = "/Employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * @param employeeService
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * @return Flux<Employee>
     */
    @GetMapping(value = "")
    public Flux<Employee> all() {
        return this.employeeService.all();
    }

    /**
     * @param id
     * @return Mono<Employee>
     */
    @GetMapping(value = "/{id}")
    public Mono<Employee> get(@PathVariable(value = "id") String id) {
        return this.employeeService.get(id);
    }

    /**
     * @param employee
     * @return Mono<Employee>
     */
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createEmp(@RequestBody Employee employee) {

        return this.employeeService.createEmp(employee);
    }

    /**
     * @param id
     */
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") String id) {
        employeeService.delete(id);
    }

}


