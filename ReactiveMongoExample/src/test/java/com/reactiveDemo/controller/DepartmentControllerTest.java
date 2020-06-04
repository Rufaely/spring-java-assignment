package com.reactiveDemo.controller;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DepartmentControllerTest {

    @Autowired
    private DepartmentController departmentController;

    @MockBean
    private DepartmentService departmentService;


    Mono<Department> departmentMono;
    Flux<Department> departmentFlux;

    @BeforeEach
    public void setup() {

        Employee employee1 = new Employee();
        employee1.setFirstName("Rufael");
        employee1.setLastName("Kidanemariam");

        Employee employee2 = new Employee();
        employee2.setFirstName("Mekonen");
        employee2.setLastName("Yohannes");

        Employee employee3 = new Employee();
        employee3.setFirstName("Mekonen");
        employee3.setLastName("Kidanemariam");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Department department1 = new Department();
        department1.setEmployees(employees);
        department1.setName("Finance");
        Department department2 = new Department();
        department2.setName("Admin");


        departmentMono = Mono.just(department1);
        departmentFlux = Flux.just(department1, department2);
    }

    @Test
    public void contexLoads() throws Exception {
        assertThat(departmentController).isNotNull();
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testingDepController() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/Department",
                Department.class));
    }

    @Test
    void testGetAllDepartments() {
        when(departmentService.getAllDepartments()).thenReturn(departmentFlux);
        Flux<Department> actualDeps = departmentController.getAllDepartments();
        assertThat(actualDeps).isEqualTo(departmentFlux);
    }

    @Test
    void testGetDepartment() {
        when(departmentService.getDepartment("1")).thenReturn(departmentMono);
        Mono<Department> actualDep = departmentController.getDepartment("1");
        assertThat(actualDep).isEqualTo(departmentMono);
    }

    @Test
    void testCreateDepartment() {
        when(departmentService.createDepartment(departmentMono.block())).thenReturn(departmentMono);
        Mono<Department> actualDep = departmentController.createDepartment(departmentMono.block());
        assertThat(actualDep).isEqualTo(departmentMono);
    }

    @Test
    void testDeleteDepartment() {
        when(departmentService.deleteDepartment("1")).thenReturn(departmentMono);
        Mono<Department> actualDep = departmentController.deleteDepartment("1");
        assertThat(actualDep).isEqualTo(departmentMono);
    }

    /*@Test
    void deleteAllDepartments() {
        when(departmentService.deleteAllDepartments()).thenReturn(departmentFlux);
        Flux<Department> actualDeps = departmentController.deleteAllDepartments();
        assertThat(actualDeps).isEqualTo(departmentFlux);

    }*/
}