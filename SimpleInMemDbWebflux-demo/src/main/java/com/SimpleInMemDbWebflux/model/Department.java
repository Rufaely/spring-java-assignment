package com.SimpleInMemDbWebflux.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Data
@ToString
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("department")
public class Department implements Serializable {

    @Id
    private long id;
    private String name;
    private List<Employee> employees;

}
