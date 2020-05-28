package com.reactiveDemo.repository;

import com.reactiveDemo.model.Department;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * created by Rufael K yohannes
 */
public interface DepartmentRepo extends ReactiveMongoRepository<Department, String> {
}
