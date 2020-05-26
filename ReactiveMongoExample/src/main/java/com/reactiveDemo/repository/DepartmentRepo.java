package com.reactiveDemo.repository;

import com.reactiveDemo.model.Department;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DepartmentRepo extends ReactiveMongoRepository<Department, String> {
}
