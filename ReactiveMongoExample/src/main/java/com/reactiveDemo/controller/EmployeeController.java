package com.reactiveDemo.controller;

import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.EmployeeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/Employee")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    /**
     * @param employeeRepo
     */
    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
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
    public Mono<Employee> get(@PathVariable(value = "id") String id) {
        return this.employeeRepo.findById(id);
    }

    /**
     * @param employee
     * @return Mono<Employee>
     */
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createPost(@RequestBody Employee employee) {
        Employee newEmp = new Employee();
        newEmp.setFirstName(employee.getFirstName());
        newEmp.setLastName(employee.getLastName());
        return this.employeeRepo.save(newEmp);
    }
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") String id){
         employeeRepo.deleteById(id);
    }

}

