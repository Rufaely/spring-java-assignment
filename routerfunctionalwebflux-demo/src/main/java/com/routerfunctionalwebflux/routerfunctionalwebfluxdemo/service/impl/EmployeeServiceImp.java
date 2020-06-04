package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.impl;


import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Employee;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.repository.EmployeeRepo;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.EmployeeService;
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
    public Flux<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    /**
     * @param id
     * @return Mono<Employee>
     */
    @Override
    public Mono<Employee> getEmployee(String id) {
        return employeeRepo.findById(id);
    }

    /**
     * @param employee
     * @return Mono<Employee>
     */
    @Override
    public Mono<Employee> createEmployee(Employee employee) {
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
    public Mono<Employee> deleteEmployee(String id) {
        return employeeRepo.findById(id)
                .flatMap(oldValue ->
                        employeeRepo.deleteById(id)
                                .then(Mono.just(oldValue))).single();

    }

}
