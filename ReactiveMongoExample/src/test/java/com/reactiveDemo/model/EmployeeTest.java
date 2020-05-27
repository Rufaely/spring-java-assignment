package com.reactiveDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeTest {

    Employee employee = new Employee();
    @BeforeEach
    void setUp() {
        employee.setFirstName("Rufael");
        employee.setLastName("Yohannes");
    }

    @Test
    void getId() {
        assertNull(employee.getId());
    }

    @Test
    void getFirstName() {
        assertEquals(employee.getFirstName(),"Rufael");
    }

    @Test
    void getLastName() {
        assertEquals(employee.getLastName(),"Yohannes");
    }

    @Test
    void setId() {
        employee.setId("1");
        assertEquals(employee.getId(),"1");
    }

    @Test
    void setFirstName() {
        employee.setFirstName("Kidanemariam");
        assertEquals(employee.getFirstName(),"Kidanemariam");
    }

    @Test
    void setLastName() {
        assertNotEquals(employee.getLastName(),"Kidanemariam");
    }
}