package com.SimpleInMemDbWebflux.repository;

import com.SimpleInMemDbWebflux.model.Department;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class DepartmentRepo {
    private static final Map<Long, Department> DATA = new HashMap<>();
    private static long ID_COUNTER = 1L;

    static {
        Arrays.asList("First Department", "Second Department")
                .stream()
                .forEach( name -> {
                    long id = ID_COUNTER++;
                    DATA.put(id, new Department(id, name));
                });
    }
    public Flux<Department> findAll() {
        return Flux.fromIterable(DATA.values());
    }

    public Mono<Department> findById(Long id){
        return Mono.just(DATA.get(id));
    }
    public Mono<Department> createPost(Department dep) {
        long id = ID_COUNTER++;
        dep.setId(id);
        DATA.put(id, dep);
        return Mono.just(dep);
    }
}
