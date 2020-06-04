package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * created by Rufael K yohannes
 */
@Setter
@Getter
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "organization")
public class Employee implements Serializable {

    @Id
    private String id;
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    @NotNull(message = "FirstName can not be null")
    private String firstName;
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    @NotNull(message = "LastName can not be null")
    private String lastName;

}