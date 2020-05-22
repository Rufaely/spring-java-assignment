package com.SimpleInMemDbWebflux.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Objects;

@Data
@ToString
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("employee")
public class Employee implements Serializable {

    @Id
    private long id;
    private String firstName;
    private String lastName;

    /**
     * @param o
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
