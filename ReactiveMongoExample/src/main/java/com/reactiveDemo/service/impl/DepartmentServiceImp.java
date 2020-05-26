package com.reactiveDemo.service.impl;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.DepartmentRepo;
import com.reactiveDemo.service.DepartmentService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImp(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }


    @Override
    public Flux<Department> all() {
        return departmentRepo.findAll();
    }

    @Override
    public Mono<Department> get(String id) {
        return departmentRepo.findById(id);
    }

    @Override
    public Mono<Department> createDep(Department department) {
        Employee newEmp = new Employee();
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : department.getEmployees()) {
            newEmp.setFirstName(employee.getFirstName());
            newEmp.setLastName(employee.getLastName());
            employees.add(newEmp);
        }
        Department newDep = new Department();
        newDep.setEmployees(employees);
        newDep.setName(department.getName());
        return this.departmentRepo.save(newDep);
    }

    @Override
    public void delete(String id) {
        departmentRepo.deleteById(id);
    }
}
