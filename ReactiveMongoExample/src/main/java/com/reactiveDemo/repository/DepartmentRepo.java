package com.reactiveDemo.repository;

import com.reactiveDemo.model.Department;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Rufael K yohannes
 */
@Repository
public interface DepartmentRepo extends ReactiveMongoRepository<Department, String> {
}
