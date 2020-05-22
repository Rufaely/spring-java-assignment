package com.SimpleInMemDbWebflux.repository.Impl;

import com.SimpleInMemDbWebflux.model.Department;
import com.SimpleInMemDbWebflux.model.Employee;
import com.SimpleInMemDbWebflux.repository.DepartmentRepo;
import com.SimpleInMemDbWebflux.repository.DepartmentRepoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Component
public class DepartmentRepoImpl implements DepartmentRepoInterface {
    private Logger logger = LoggerFactory.getLogger(DepartmentRepoImpl.class);
    private static final Map<Long, Department> DATA = new HashMap<>();
    private static long ID_COUNTER = 1L;
    @Autowired
    DepartmentRepo departmentRepo;
   /* @Autowired
    private ReactiveRedisTemplate<String, Department> template;
    private ReactiveRedisOperations<String, Department> deptOps;*/
    @Autowired
    private ReactiveRedisConnectionFactory factory;

    static {
        Employee employee1 = new Employee(1,"First Name","Last Name");
        Employee employee2 = new Employee(2,"Rufael","Yohanne");
        Employee employee3 = new Employee(3,"Solomon","Kidane");
        Employee employee4 = new Employee(4,"Merih","Gebre");

        List<Employee> employees1 = new ArrayList<>();
        employees1.add(employee2);
        employees1.add(employee3);

        List<Employee> employees2 = new ArrayList<>();
        employees2.add(employee1);
        employees2.add(employee4);


        Department department1 = new Department(1,"Finance",employees1);
        Department department2 = new Department(2,"Accounting",employees2);

        List<Department> departments = new ArrayList<>();
        departments.add(department1);
        departments.add(department2);

        departments.stream()
                .forEach(dep->{
                    Long id = ID_COUNTER++;
                    DATA.put(id,dep);
                });


    }

    @Override
    public Flux<Department> findAllInitial() {
        return Flux.fromIterable(DATA.values());
    }

    /**
     * @return Flux<Department>
     */
    public Flux<Department> findAll() {
        return Flux.fromIterable(departmentRepo.findAll());
    }

    /**
     * @param id
     * @return Mono<Department>
     */
    public Mono<Department> findById(Long id) {

      return Mono.just(departmentRepo.findById(id).get());

    }

    /**
     * @param department
     * @return Mono<Department>
     */
    public Mono<Department> createPost(Department department) {
        List<Employee> employees = department.getEmployees();
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee:employees){
            employeeList.add(employee);
        }
        Department dep = new Department();
        dep.setName(department.getName());
        dep.setEmployees(employeeList);

        try{
            Mono<Department> result =  factory.getReactiveConnection().serverCommands().bgSave().then(Mono.just(departmentRepo.save(dep)));
//            Mono.just(departmentRepo.save(dep));
        }
        catch (DuplicateKeyException e){
            logger.info("For Department "+ dep.getName()+" " +dep.getId() +"is on DB");
            System.out.println("For Department "+ dep.getName()+" " +dep.getId() +"is on DB");
        }
       return Mono.just(departmentRepo.findById(department.getId()).get());
    }
}
