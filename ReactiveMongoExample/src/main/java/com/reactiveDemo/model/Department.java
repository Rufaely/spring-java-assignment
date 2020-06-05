package com.reactiveDemo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * created by Rufael K yohannes
 */
//@Data
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Department implements Serializable {

    @Id
    private String id;
    @NotNull(message = "Department name can not be null")
    @Pattern(regexp = "^[A-Za-z]*$")
    private String name;
    @NonNull
    private List<Employee> employees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}