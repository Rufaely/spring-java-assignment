package com.reactiveDemo.service.impl;

import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.EmployeeRepo;
import com.reactiveDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * created by Rufael K yohannes
 */
@Component
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;

    /**
     * @param employeeRepo
     */
    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /**
     * @return Flux<Employee>
     */
    @Override
    public Flux<Employee> all() {
        return employeeRepo.findAll();
    }

    /**
     * @param id
     * @return Mono<Employee>
     */
    @Override
    public Mono<Employee> get(String id) {
        return employeeRepo.findById(id);
    }

    /**
     * @param employee
     * @return Mono<Employee>
     */
    @Override
    public Mono<Employee> createEmp(Employee employee) {
        Employee newEmp = new Employee();
        newEmp.setFirstName(employee.getFirstName());
        newEmp.setLastName(employee.getLastName());
        return this.employeeRepo.save(newEmp);
    }

    /**
     * @param id
     * @return Mono<Employee>
     */
    @Override
    public Mono<Employee> delete(String id) {
        return employeeRepo.findById(id)
                .flatMap(oldValue ->
                        employeeRepo.deleteById(id)
                                .then(Mono.just(oldValue))).single();

    }

}
