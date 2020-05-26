package com.reactiveDemo.service;

import com.reactiveDemo.model.Department;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface DepartmentService {
    public Flux<Department> all();

    public Mono<Department> get(String id);

    public Mono<Department> createDep(Department department);

    public void delete(String id);
}
