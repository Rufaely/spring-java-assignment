package com.SimpleInMemDbWebflux.service;

import com.SimpleInMemDbWebflux.model.Department;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DepartmentRepoInterface {

    /**
     * @return
     */
    public Flux<Department> findAllInitial();
    /**
     * @return
     */
    public Flux<Department> findAll();

    /**
     * @param id
     * @return Mono<Department>
     */
    public Mono<Department> findById(Long id);

    /**
     * @param dep
     * @return Mono<Department>
     */
    public Mono<Department> createPost(Department dep);

}
