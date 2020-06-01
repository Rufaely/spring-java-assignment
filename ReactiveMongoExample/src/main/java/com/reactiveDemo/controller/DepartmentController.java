
package com.reactiveDemo.controller;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * created by Rufael K yohannes
 */
@RestController
@RequestMapping(value = "/Department")
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * @param departmentService
     */
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    /**
     * @return Flux<Department>
     */
    @GetMapping(value = "")
    public Flux<Department> all() {
        return this.departmentService.all();
    }

    /**
     * @param id
     * @return Mono<Department>
     */
    @GetMapping(value = "/{id}")
    public Mono<Department> get(@Valid @PathVariable(value = "id") String id) {
        return this.departmentService.get(id);
    }

    /**
     * @param department
     * @return Mono<Department>
     */
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Department> createDep(@Valid @RequestBody Department department) {
        return this.departmentService.createDep(department);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Mono<Department> delete(@Valid @PathVariable(value = "id") String id){
        return departmentService.delete(id);
    }

}

