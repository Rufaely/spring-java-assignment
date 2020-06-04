package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service;

import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Department;
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
    public Flux<Department> getAllDepartments();

    /**
     * @param id
     * @return Mono<Department>
     */
    public Mono<Department> getDepartment(String id);

    /**
     * @param department
     * @return Mono<Department>
     */
    public Mono<Department> createDepartment(Department department);


    /**
     * @param id
     * @return Mono<Department>
     */
    public Mono<Department> deleteDepartment(String id);
}
