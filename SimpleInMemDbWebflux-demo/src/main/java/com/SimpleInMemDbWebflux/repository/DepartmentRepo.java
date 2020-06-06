package com.SimpleInMemDbWebflux.repository;

import com.SimpleInMemDbWebflux.model.Department;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DepartmentRepo extends CrudRepository<Department, Long> {
}
