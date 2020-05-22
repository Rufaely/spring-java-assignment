package com.SimpleInMemDbWebflux.repository;

import com.SimpleInMemDbWebflux.model.Department;
import com.SimpleInMemDbWebflux.model.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Component
public class DepartmentRepo {
    private static final Map<Long, Department> DATA = new HashMap<>();
    private static long ID_COUNTER = 1L;

    static {
        Arrays.asList("First Department", "Second Department")
                .stream()
                .forEach( name -> {
                    long id = ID_COUNTER++;
                    List<Employee> emp = new ArrayList<Employee>();
                    DATA.put(id, new Department(id, name, emp));
                });
    }

    /**
     * @return Flux<Department>
     */
    public Flux<Department> findAll() {
        return Flux.fromIterable(DATA.values());
    }

    /**
     * @param id
     * @return Mono<Department>
     */
    public Mono<Department> findById(Long id){
        return Mono.just(DATA.get(id));
    }

    /**
     * @param dep
     * @return Mono<Department>
     */
    public Mono<Department> createPost(Department dep) {
        long id = ID_COUNTER++;
        dep.setId(id);
        DATA.put(id, dep);
        return Mono.just(dep);
    }
}
