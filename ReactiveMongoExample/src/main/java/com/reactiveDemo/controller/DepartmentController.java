package com.reactiveDemo.controller;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.DepartmentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Department")
public class DepartmentController {

    private final DepartmentRepo departmentRepo;

    /**
     * @param departmentRepo
     */
    public DepartmentController(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    /**
     * @return Flux<Department>
     */
    @GetMapping(value = "")
    public Flux<Department> all() {
        return this.departmentRepo.findAll();
    }

    /**
     * @param id
     * @return Mono<Department>
     */
    @GetMapping(value = "/{id}")
    public Mono<Department> get(@PathVariable(value = "id") String id) {
        return this.departmentRepo.findById(id);
    }

    /**
     * @param department
     * @return Mono<Department>
     */
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Department> createPost(@RequestBody Department department) {
        Employee newEmp = new Employee();
        List<Employee> employees = new ArrayList<>();
        for(Employee employee:department.getEmployees()) {
            newEmp.setFirstName(employee.getFirstName());
            newEmp.setLastName(employee.getLastName());
            employees.add(newEmp);
        }
        Department newDep = new Department();
        newDep.setEmployees(employees);
        newDep.setName(department.getName());
        return this.departmentRepo.save(department);
    }
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") String id){
        departmentRepo.deleteById(id);
    }

}

