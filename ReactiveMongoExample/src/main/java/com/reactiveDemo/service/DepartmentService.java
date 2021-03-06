package com.reactiveDemo.service;

import com.reactiveDemo.model.Department;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * created by Rufael K yohannes
 */
@Service
public interface DepartmentService {
    /**
     * @return Flux<Department>
     */
    public Flux<Department> all();

    /**
     * @param id
     * @return Mono<Department>
     */
    public Mono<Department> get(String id);

    /**
     * @param department
     * @return Mono<Department>
     */
    public Mono<Department> createDep(Department department);


    /**
     * @param id
     * @return Mono<Department>
     */
    public Mono<Department> deleteDep(String id);
}
