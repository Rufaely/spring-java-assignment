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
    void testEmpConstructorWithArg(){
        Employee empConstructor = new Employee("1","rafi","kidun");
        assertEquals("1",empConstructor.getId());
        assertEquals("rafi",empConstructor.getFirstName());
        assertEquals("kidun",empConstructor.getLastName());
    }
    @Test
    void testEmpConstructorWithOutArg(){
        Employee empConstructor = new Employee();
        assertEquals(null,empConstructor.getId());
        assertEquals(null,empConstructor.getFirstName());
        assertEquals(null,empConstructor.getLastName());
    }
    @Test
    void testGetId() {
        assertNull(employee.getId());
    }

    @Test
    void testSetId() {
        employee.setId("1");
        assertEquals(employee.getId(),"1");
    }

    @Test
    void testGetFirstName() {
        assertEquals(employee.getFirstName(),"Rufael");
    }

    @Test
    void testSetFirstName() {
        employee.setFirstName("Kidanemariam");
        assertEquals(employee.getFirstName(),"Kidanemariam");
    }

    @Test
    void testGetLastName() {
        assertEquals(employee.getLastName(),"Yohannes");
    }

    @Test
    void testSetLastName() {
        employee.setLastName("Yohannes");
        assertEquals(employee.getLastName(),"Yohannes");
    }
}
