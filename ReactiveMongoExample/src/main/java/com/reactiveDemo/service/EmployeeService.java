package com.reactiveDemo.service;

import com.reactiveDemo.model.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface EmployeeService {
    public Flux<Employee> all();

    public Mono<Employee> get(String id);

    public Mono<Employee> createEmp(Employee employee);

    public void delete(String id);
}
