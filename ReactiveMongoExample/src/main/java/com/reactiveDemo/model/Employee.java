package com.reactiveDemo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * created by Rufael K yohannes
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee implements Serializable {

    @Id
    private String id;
    @Pattern(regexp = "[a-zA-Z]")
    @NotNull(message = "FirstName can not be null")
    private String firstName;
    @Pattern(regexp = "[a-zA-Z]")
    @NotNull(message = "LastName can not be null")
    private String lastName;
}