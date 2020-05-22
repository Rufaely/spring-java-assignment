package com.SimpleInMemDbWebflux.controller;

import com.SimpleInMemDbWebflux.model.Department;
import com.SimpleInMemDbWebflux.repository.DepartmentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 *
 */
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
    public Mono<Department> get(@PathVariable(value = "id") Long id) {
        return this.departmentRepo.findById(id);
    }

    /**
     * @param department
     * @return Mono<Department>
     */
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Department> create(Department department) {
        return this.departmentRepo.createPost(department);
    }

}
