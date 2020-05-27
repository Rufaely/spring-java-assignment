
package com.reactiveDemo.controller;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<Department> get(@PathVariable(value = "id") String id) {
        return this.departmentService.get(id);
    }

    /**
     * @param department
     * @return Mono<Department>
     */
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Department> createDep(@RequestBody Department department) {
        return this.departmentService.createDep(department);
    }

    /**
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") String id){
        departmentService.delete(id);
    }

}


