package com.SimpleInMemDbWebflux.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.Objects;

/**
 *
 */
@Data
@ToString
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("department")
public class Department {

    @Id
    private long id;
    private String name;
    private List<Employee> employees;

}
