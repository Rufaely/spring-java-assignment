package com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.handler;

import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Department;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.model.Employee;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.repository.DepartmentRepo;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.repository.EmployeeRepo;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.DepartmentService;
import com.routerfunctionalwebflux.routerfunctionalwebfluxdemo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


//@ContextConfiguration(classes = {RouterFunction.class, RouterHandler.class})
@SpringBootTest
//        (classes = RouterHandler.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWebTestClient
@RunWith(SpringRunner.class)
class RouterHandlerTest {

    @Autowired
    RouterHandler routerHandler;
    @Autowired
    RouterFunction<?> routerFunction;

    @MockBean
    private DepartmentService departmentService;
    @MockBean
    EmployeeService employeeService;
    @MockBean
    private DepartmentRepo departmentRepo;
    @MockBean
    private EmployeeRepo employeeRepo;
    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToRouterFunction(routerFunction).build();
    }

    @Test
    public void contexLoads() throws Exception {
        assertThat(routerFunction).isNotNull();
        assertThat(routerHandler).isNotNull();
    }

//    @Test
//    void testGetAllDep() {
//        List<Employee> employees = Arrays.asList(
//                new Employee("1", "First Name","Second Name"),
//                new Employee("2", "First", "Second"));
//        List<Department> departments = Arrays.asList(
//                new Department("1", "Finance",employees),
//                new Department("2", "Admin",employees));
//
//        Flux<Department> departmentFlux = Flux.fromIterable(departments);
//        given(departmentRepo.findAll()).willReturn(departmentFlux);
//
//        webTestClient.get()
//                .uri("/Department")
//                .exchange()
//                .expectStatus()
//                .isOk()
//                .expectBodyList(Department.class)
//                .isEqualTo(departments);
//    }
//
//    @Test
//    void testGetDepById() {
//        List<Employee> employees = Arrays.asList(
//                new Employee("1", "First Name","Second Name"),
//                new Employee("2", "First", "Second"));
//        Department department = new Department();
//        department.setId("1");
//        department.setName("Admin");
//        department.setEmployees(employees);
//        given(departmentRepo.findById("1")).willReturn(Mono.just(department));
//
//        WebTestClient.bindToRouterFunction(routerFunction).build().get()
//                .uri("/Department/1")
//                .exchange()
//                .expectStatus()
//                .isOk()
//                .expectBody(Department.class)
//                .isEqualTo(department);
//
//    }

//    @Test
//    void testCreateDep() {
//        List<Employee> employees = Arrays.asList(
//                new Employee("1", "First Name","Second Name"),
//                new Employee("2", "First", "Second"));
//        Department department = new Department();
//        department.setId("1");
//        department.setName("Admin");
//        department.setEmployees(employees);
//        Mockito.when(departmentRepo.save(department)).thenReturn(Mono.just(department));
//
//        WebTestClient.bindToRouterFunction(routerFunction).build().post()
//                .uri("/Department")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromObject(department))
//                .exchange()
//                .expectStatus().isCreated();
//
//        Mockito.verify(departmentRepo, times(1)).save(department);
//
//    }
//
//    @Test
//    void testDeleteDep() {
//    }
//
//    @Test
//    void testGetAllEmp() {
//        List<Employee> employees = Arrays.asList(
//                new Employee("1", "First Name","Second Name"),
//                new Employee("2", "First", "Second"));
//
//        Flux<Employee> employeeFlux = Flux.fromIterable(employees);
//        given(employeeRepo.findAll()).willReturn(employeeFlux);

//        StepVerifier.create(WebTestClient
//                .bindToRouterFunction(routerFunction)
//                .build()
//                .get().uri("/Employee")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .returnResult(Employee.class)
//                .getResponseBody())
//
//                .expectNext(new Employee("1", "First Name","Second Name"))
//                .expectNext(new Employee("2", "First","Second"))
//                .verifyComplete();
//    }
//
//    @Test
//    void testGetEmpById() {
//        Employee employee = new Employee();
//        employee.setId("1");
//        employee.setFirstName("Test");
//        employee.setLastName("test");
////        given(employeeRepo.findById("1")).willReturn(employeeRepo.save(employee);
//
//        StepVerifier.create(WebTestClient
//                .bindToRouterFunction(routerFunction)
//                .build()
//                .get().uri("/Employee/1")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .returnResult(Employee.class)
//                .getResponseBody())
//                .expectSubscription()
//                .expectNext(new Employee("1", "Test","test"))
//                .verifyComplete();
//    }

//    @Test
//    void testCreateEmp() {
//        Employee employee = new Employee();
//        employee.setId("1");
//        employee.setFirstName("Test");
//        employee.setLastName("test");
//
//        Mockito.when(employeeRepo.save(employee)).thenReturn(Mono.just(employee));
//
//        webTestClient.post()
//                .uri("/Employee")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromObject(employee))
//                .exchange()
//                .expectStatus().isCreated();
//
//        Mockito.verify(employeeRepo, times(1)).save(employee);
//    }
//
//    @Test
//    void testDeleteEmp() {
//        webTestClient.get().uri("/Employee")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody().json("{}");
//    }

}
