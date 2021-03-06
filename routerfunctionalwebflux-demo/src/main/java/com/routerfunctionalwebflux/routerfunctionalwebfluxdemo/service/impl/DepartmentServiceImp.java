package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.impl;


import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Department;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Employee;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.repository.DepartmentRepo;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.DepartmentService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Rufael K yohannes
 */
@Component
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepo departmentRepo;

    /**
     * @param departmentRepo
     */
    public DepartmentServiceImp(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }


    /**
     * @return Flux<Department>
     */
    @Override
    public Flux<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    /**
     * @param id
     * @return Mono<Department>
     */
    @Override
    public Mono<Department> getDepartment(String id) {
        return departmentRepo.findById(id);
    }

    /**
     * @param department
     * @return Mono<Department>
     */
    @Override
    public Mono<Department> createDepartment(Department department) {
        Employee newEmp = new Employee();
        List<Employee> employees = new ArrayList<>();
        Department newDep = new Department();
        for (Employee employee : department.getEmployees()) {
            employees.add(employee);
        }
        newDep.setEmployees(employees);
        newDep.setName(department.getName());

        return this.departmentRepo.save(newDep);
    }


    /**
     * @param id
     * @return Mono<Department>
     */
    @Override
    public Mono<Department> deleteDepartment(String id) {
        return departmentRepo.findById(id)
                .flatMap(oldValue ->
                        departmentRepo.deleteById(id)
                                .then(Mono.just(oldValue))).single();

    }

}