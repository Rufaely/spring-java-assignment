package com.reactiveDemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentTest {

    Employee employee= new Employee();
    Department department = new Department();
    List<Employee> employees = new ArrayList<>();
    @BeforeEach
    void setUp() {
        employee.setFirstName("Rufael");
        employee.setLastName("kidanemariam");
        employees.add(employee);
        department.setName("Finance");
    }
    @Test
    void getId() {
        assertNull(department.getId());
    }

    @Test
    void getName() {
        assertEquals(department.getName(),"Finance");
    }


    @Test
    void setId() {
        department.setId("1");
        assertEquals(department.getId(),"1");
    }

    @Test
    void setName() {
        department.setName("Commerce");

        assertEquals(department.getName(),"Commerce");
    }
}
