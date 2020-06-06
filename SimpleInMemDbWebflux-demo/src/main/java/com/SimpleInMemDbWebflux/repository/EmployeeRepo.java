package com.SimpleInMemDbWebflux.repository;

import com.SimpleInMemDbWebflux.model.Employee;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepo  extends CrudRepository<Employee, Long> {
}
