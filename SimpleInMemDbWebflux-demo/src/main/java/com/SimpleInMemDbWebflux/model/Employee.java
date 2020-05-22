package com.SimpleInMemDbWebflux.model;

import lombok.*;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Objects;

@Data
@ToString
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Indexed
    private long id;
    private String firstName;
//    private String lastName;

    /**
     * @param Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                firstName.equals(employee.firstName) ;
//                && lastName.equals(employee.lastName);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }
}
