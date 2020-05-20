package com.SimpleInMemDbWebflux.repository;


import com.SimpleInMemDbWebflux.model.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//import static com.SimpleInMemDbWebflux.model.Employee.builder;

@Component
public class EmployeeRepo {
    private static final Map<Long, Employee> DATA = new HashMap<>();
    private static long ID_COUNTER = 1L;

    {
        Arrays.asList("First firstName", "Second firstName", "Merih", "Rufael")
                .stream()
                .forEach((firstName) -> {
                            long id = ID_COUNTER++;

                            DATA.put(id, new Employee(id, firstName));
                        }
                );
    }


    public Flux<Employee> findAll() {
        return Flux.fromIterable(DATA.values());
    }

    public Mono<Employee> findById(Long id) {
        return Mono.just(DATA.get(id));
    }

    public Mono<Employee> createPost(Employee emp) {
        long id = ID_COUNTER++;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(emp.getFirstName());
        DATA.put(id, employee);
        return Mono.just(employee);
    }
}
