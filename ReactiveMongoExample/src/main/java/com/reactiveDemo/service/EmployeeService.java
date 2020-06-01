package com.reactiveDemo.service;

import com.reactiveDemo.model.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * created by Rufael K yohannes
 */
@Service
public interface EmployeeService {
    /**
     * @return Flux<Employee>
     */
    public Flux<Employee> all();

    /**
     * @param id
     * @return Mono<Employee>
     */
    public Mono<Employee> get(String id);

    /**
     * @param employee
     * @return Mono<Employee>
     */
    public Mono<Employee> createEmp(Employee employee);

    /**
     * @param id
     * @return Mono<Employee>
     */
    public Mono<Employee> delete(String id);

}
