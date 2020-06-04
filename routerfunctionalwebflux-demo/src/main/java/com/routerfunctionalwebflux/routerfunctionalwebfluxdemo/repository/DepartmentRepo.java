package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.repository;

import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Department;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * created by Rufael K yohannes
 */
@Repository
public interface DepartmentRepo extends ReactiveMongoRepository<Department, String> {
}
