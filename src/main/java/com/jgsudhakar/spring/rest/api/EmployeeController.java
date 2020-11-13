package com.jgsudhakar.spring.rest.api;

import com.jgsudhakar.spring.rest.dto.response.EmployeeRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.rest.api.EmployeeController
 * @Date : 12/11/2020
 */
@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

    private List<EmployeeRes> empList = Arrays.asList(
            new EmployeeRes(1l,"Sudhakar","Product"),
            new EmployeeRes(2l,"Sriyaan","Product"),
            new EmployeeRes(3l,"Sanvi","Product")
    );

    @GetMapping("")
    public List<EmployeeRes> getEmployees() {
        return empList;
    }

    @GetMapping("{id}")
    public EmployeeRes getEmployeeById(@PathVariable(name = "id") Long id) {
        return empList.
                stream().
                filter(x -> x.getEmpId() == id).
                findAny().get();
    }
}
