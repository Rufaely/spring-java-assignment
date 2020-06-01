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
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Department implements Serializable {

    @Id
    private String id;
    @Pattern(regexp = "[a-zA-Z]")
    @NotNull(message = "Department name can not be null")
    private String name;
    @NonNull
    private List<Employee> employees;


}