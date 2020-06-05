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
//@Data
//@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee implements Serializable {

    @Id
    private String id;
    @NotNull(message = "FirstName can not be null")
    @Pattern(regexp = "^[A-Za-z]*$")
    private String firstName;
    @NotNull(message = "LastName can not be null")
    @Pattern(regexp = "^[A-Za-z]*$")
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}