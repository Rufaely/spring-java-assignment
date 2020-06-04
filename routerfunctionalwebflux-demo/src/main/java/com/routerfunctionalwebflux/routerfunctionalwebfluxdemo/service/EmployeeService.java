package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service;

import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Employee;
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
    public Flux<Employee> getAllEmployees();

    /**
     * @param id
     * @return Mono<Employee>
     */
    public Mono<Employee> getEmployee(String id);

    /**
     * @param employee
     * @return Mono<Employee>
     */
    public Mono<Employee> createEmployee(Employee employee);

    /**
     * @param id
     * @return Mono<Employee>
     */
    public Mono<Employee> deleteEmployee(String id);

}
