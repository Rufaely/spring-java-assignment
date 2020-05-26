package com.reactiveDemo.service.impl;

import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.EmployeeRepo;
import com.reactiveDemo.service.EmployeeService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Flux<Employee> all() {
        return employeeRepo.findAll();
    }

    @Override
    public Mono<Employee> get(String id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Mono<Employee> createEmp(Employee employee) {
        Employee newEmp = new Employee();
        newEmp.setFirstName(employee.getFirstName());
        newEmp.setLastName(employee.getLastName());
        return this.employeeRepo.save(newEmp);
    }

    @Override
    public void delete(String id) {
        employeeRepo.deleteById(id);
    }
}
