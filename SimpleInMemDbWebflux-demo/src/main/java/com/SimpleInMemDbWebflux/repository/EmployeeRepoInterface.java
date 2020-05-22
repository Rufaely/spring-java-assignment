package com.SimpleInMemDbWebflux.repository;

import com.SimpleInMemDbWebflux.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepoInterface {

    /**
     * @return
     */
    public Flux<Employee> findAllInitial();
    /**
     * @return
     */
    public Flux<Employee> findAll();

    /**
     * @param id
     * @return Mono<Employee>
     */
    public Mono<Employee> findById(Long id);

    /**
     * @param emp
     * @return Mono<Employee>
     */
    public Mono<Employee> createPost(Employee emp);

}
