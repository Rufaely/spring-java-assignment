package com.reactiveDemo.repository;

import com.reactiveDemo.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepo extends ReactiveMongoRepository<Employee, String> {
}
