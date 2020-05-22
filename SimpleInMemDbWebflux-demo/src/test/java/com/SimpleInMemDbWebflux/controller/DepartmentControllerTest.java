/*
package com.SimpleInMemDbWebflux.controller;

import com.SimpleInMemDbWebflux.model.Department;
import com.SimpleInMemDbWebflux.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;

class DepartmentControllerTest {

    @Autowired
    WebTestClient webTestClient;
    Employee employee;
    Department department;
    List<Employee> employees;
    @BeforeEach
    public void setUp() throws Exception {

        employee.setFirstName("Raf");
        employees.add(employee);
        department.setName("Finance");
        department.setEmployees(employees);

    }


    @Test
    public void all() {
    }

    @Test
    public void get() {


    }

    @Test
    public void create() {
        webTestClient.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(department)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .jsonPath("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"First Department\",\n" +
                        "        \"employees\": []\n" +
                        "    }\n" +
                        "]")
                .value(val -> assertThat(val).isEqualTo(department));
    }
}
*/
