
package com.reactiveDemo.controller;

import com.reactiveDemo.model.Department;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.service.EmployeeService;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    Mono<Employee> employeeMono;
    Flux<Employee> employeeFlux;

    @BeforeEach
    public void setup(){

        Employee employee1 = new Employee();
        employee1.setFirstName("Rufael");
        employee1.setLastName("Kidanemariam");

        Employee employee2 = new Employee();
        employee2.setFirstName("Mekonen");
        employee2.setLastName("Yohannes");

        Employee employee3 = new Employee();
        employee3.setFirstName("Mekonen");
        employee3.setLastName("Kidanemariam");

        employeeMono = Mono.just(employee1);
        employeeFlux = Flux.just(employee1,employee2,employee3);
    }

    @Test
    public void contexLoads() throws Exception {
        assertThat(employeeController).isNotNull();
    }


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testingEmpController() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/Employee",
                Employee.class));
    }

    @Test
    public void get(){
        when(employeeService.get("1")).thenReturn(employeeMono);
        Mono<Employee> actualEmp = employeeController.get("1");
        assertThat(actualEmp).isEqualTo(employeeMono);

    }
    @Test
    public void all(){
        when(employeeService.all()).thenReturn(employeeFlux);
        Flux<Employee> actualEmps = employeeController.all();
        assertThat(actualEmps).isEqualTo(employeeFlux);

    }

    @Test
    public void createEmp(){
        when(employeeService.createEmp(employeeMono.block())).thenReturn(employeeMono);
        Mono<Employee> actualEmp = employeeController.createEmp(employeeMono.block());
        assertThat(actualEmp).isEqualTo(employeeMono);
    }
    @Test
    public void delete(){
        when(employeeService.deleteEmp("1")).thenReturn(employeeMono);
        Mono<Employee> actualEmp = employeeController.deleteEmp("1");
        assertThat(actualEmp).isEqualTo(employeeMono);
    }

}


