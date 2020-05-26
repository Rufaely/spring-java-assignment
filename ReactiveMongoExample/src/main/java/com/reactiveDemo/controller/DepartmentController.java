package com.reactiveDemo.controller;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/Department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(value = "")
    public Flux<Department> all() {
        return this.departmentService.all();
    }

    @GetMapping(value = "/{id}")
    public Mono<Department> get(@PathVariable(value = "id") String id) {
        return this.departmentService.get(id);
    }
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Department> createDep(@RequestBody Department department) {
        return this.departmentService.createDep(department);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") String id){
        departmentService.delete(id);
    }

}


