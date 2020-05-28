package com.reactiveDemo.repository;

import com.reactiveDemo.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * created by Rufael K yohannes
 */
public interface EmployeeRepo extends ReactiveMongoRepository<Employee, String> {


}
