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
        department.setEmployees(employees);
        department.setName("Finance");
    }
    @Test
    void testDepConstructorWithArg(){
        List<Employee> employeeList = new ArrayList<>();
        Department depConstructor = new Department("1","rafi",employeeList);
        assertEquals("1",depConstructor.getId());
        assertEquals("rafi",depConstructor.getName());
        assertNotNull(depConstructor.getEmployees());
    }
    @Test
    void testDepConstructorWithOutArg(){

        Department depConstructor = new Department();
        assertEquals(null,depConstructor.getId());
        assertEquals(null,depConstructor.getName());
        assertEquals(null,depConstructor.getEmployees());
    }
    @Test
    void testGetId() {
        assertNull(department.getId());
    }

    @Test
    void testSetId() {
        department.setId("1");
        assertEquals(department.getId(),"1");
    }

    @Test
    void testGetName() {
        assertEquals(department.getName(),"Finance");
    }

    @Test
    void testSetName() {
        department.setName("Commerce");
        assertEquals(department.getName(),"Commerce");
    }

    @Test
    void testGetEmployees() {
        assertEquals(department.getEmployees(),employees);
    }

    @Test
    void testSetEmployees() {
        List<Employee> emp = new ArrayList<>();
        Department dep = new Department();
        dep.setEmployees(emp);
        dep.setName("Admin");
        assertEquals(dep.getEmployees(), emp);
    }
}
