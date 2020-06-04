package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model;

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
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "organization")
public class Department implements Serializable {

    @Id
    private String id;
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    @NotNull(message = "Department name can not be null")
    private String name;
    @NonNull
    private List<Employee> employees;

}