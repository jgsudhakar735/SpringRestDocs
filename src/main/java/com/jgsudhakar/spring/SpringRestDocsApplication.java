package com.jgsudhakar.spring;

import com.jgsudhakar.spring.entity.EmployeeEntity;
import com.jgsudhakar.spring.repository.EmployeeRepository;
import com.jgsudhakar.spring.rest.dto.response.EmployeeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SpringRestDocsApplication {

//    @Autowired
//    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestDocsApplication.class, args);
    }

//    @PostConstruct
//    public void insertBaseData() {
//        employeeRepository.deleteAll();
//        employeeRepository.saveAll(Arrays.asList(
//                new EmployeeEntity(null,"Sudhakar","Product"),
//                new EmployeeEntity(null,"Sriyaan","Product"),
//                new EmployeeEntity(null,"Sanvi","Product")
//        ));
//    }
}
