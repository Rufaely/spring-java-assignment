/*

package com.reactiveDemo.controller;
import static org.mockito.Mockito.times;

import com.reactiveDemo.ReactiveMongoExampleApplicationTests;
import com.reactiveDemo.model.Employee;
import com.reactiveDemo.repository.EmployeeRepo;
import com.reactiveDemo.service.impl.EmployeeServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@ContextConfiguration(classes = ReactiveMongoExampleApplicationTests.class)
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeServiceImp.class)
class EmployeeControllerTest {

    @MockBean
    EmployeeRepo employeeRepo;
    @Autowired
    private WebTestClient webClient;

    @BeforeEach
    void setUp(ApplicationContext context) {
        webClient = WebTestClient
                .bindToApplicationContext(context)
                .build();
    }


    @Test
    void all() {
        Mockito
                .when(employeeRepo.findAll())
                .thenReturn(Flux.empty());
        webClient.get().uri("/Employee")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEmpty()
                .jsonPath("$.employees").isEmpty();
        Mockito.verify(employeeRepo, times(1)).findAll();
    }

    @Test
    void getEmp() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");

        Mockito
                .when(employeeRepo.findById("2"))
                .thenReturn(Mono.just(employee));

        webClient.get().uri("/Employee/{id}", Collections.singletonMap("id", employee.getFirstName()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.firstName").isNotEmpty()
                .jsonPath("$.firstName").isEqualTo("Test First")
                .jsonPath("$.lastName").isEqualTo("Test Last");

        Mockito.verify(employeeRepo, times(1)).findById("2");
    }

    @Test
    void createEmp() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");

        Mockito.when(employeeRepo.save(employee)).thenReturn(Mono.just(employee));

        webClient.post()
                .uri("/Employee")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(employee))
                .exchange()
                .expectStatus().isCreated();

        Mockito.verify(employeeRepo, times(1)).save(employee);
    }

    @Test
    void delete() {
        Mono<Void> voidReturn = Mono.empty();
        Mockito
                .when(employeeRepo.deleteById("1"))
                .thenReturn(voidReturn);

        webClient.delete().uri("Employee/{id}", 1)
                .exchange()
                .expectStatus().isOk();
    }

}
*/
