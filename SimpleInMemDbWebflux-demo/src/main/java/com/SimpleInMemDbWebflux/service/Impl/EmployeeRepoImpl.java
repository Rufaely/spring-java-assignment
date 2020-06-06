package com.SimpleInMemDbWebflux.service.Impl;


import com.SimpleInMemDbWebflux.model.Employee;
import com.SimpleInMemDbWebflux.repository.EmployeeRepo;
import com.SimpleInMemDbWebflux.service.EmployeeRepoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeRepoImpl implements EmployeeRepoInterface {
    private Logger logger = LoggerFactory.getLogger(DepartmentRepoImpl.class);
    private static final Map<Long, Employee> DATA = new HashMap<>();
    private static long ID_COUNTER = 1L;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    private ReactiveRedisConnectionFactory factory;

    static {
        Employee employee1 = new Employee(1, "First Name", "Last Name");
        Employee employee2 = new Employee(2, "Rufael", "Yohanne");
        Employee employee3 = new Employee(3, "Solomon", "Kidane");
        Employee employee4 = new Employee(4, "Merih", "Gebre");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        employees.stream()
                .forEach(emps -> {
                    long id = ID_COUNTER++;
                    DATA.put(id, emps);
                });

    }

    @Override
    public Flux<Employee> findAllInitial() {
        return Flux.fromIterable(DATA.values());
    }

    /**
     * @return Flux<Employee>
     */
    public Flux<Employee> findAll() {

        return Flux.fromIterable(employeeRepo.findAll());
//        return Flux.fromIterable(DATA.values());
    }

    /**
     * @param id
     * @return Mono<Employee>
     */
    public Mono<Employee> findById(Long id) {

        return Mono.just(employeeRepo.findById(id).get());
//        return Mono.just(DATA.get(id));
    }

    public Mono<Employee> createPost(Employee employee) {
        Employee emp = new Employee();
        Long id = ID_COUNTER++;
        emp.setId(id);
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        try {
            factory.getReactiveConnection().serverCommands().bgSave().then(Mono.just(employeeRepo.save(emp)));
//            Mono.just(employeeRepo.save(emp));
        } catch (DuplicateKeyException e) {
            logger.info("First Name " + emp.getFirstName() + " " + emp.getId() + "is on DB");
            System.out.println("First Name " + emp.getFirstName() + " " + emp.getId() + "is on DB");
        }
        return Mono.just(employeeRepo.findById(emp.getId()).get());
    }
}

