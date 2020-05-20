package com.SimpleInMemDbWebflux.controller;

import com.SimpleInMemDbWebflux.model.Department;
import com.SimpleInMemDbWebflux.repository.DepartmentRepo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/Department")
public class DepartmentController {

    private final DepartmentRepo departmentRepo;

    public DepartmentController(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @GetMapping(value = "")
    public Flux<Department> all() {
        return this.departmentRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Department> get(@PathVariable(value = "id") Long id) {
        return this.departmentRepo.findById(id);
    }

    @PostMapping(value = "")
    public Mono<Department> create(Department department) {
        return this.departmentRepo.createPost(department);
    }

}
