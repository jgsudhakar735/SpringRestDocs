package com.jgsudhakar.spring.rest.api;

import com.jgsudhakar.spring.rest.dto.request.EmployeeReq;
import com.jgsudhakar.spring.rest.dto.response.EmployeeRes;
import com.jgsudhakar.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<EmployeeRes> getEmployees() {
        return employeeService.getEmpList();
    }

    @GetMapping("{id}")
    public EmployeeRes getEmployeeById(@PathVariable(name = "id") Long id) {
        return employeeService.get(id);
    }

    @PostMapping("")
    public EmployeeRes save(@RequestBody EmployeeReq employeeReq) {
        return employeeService.save(employeeReq);
    }

    @PutMapping("")
    public EmployeeRes update(@RequestBody EmployeeReq employeeReq) {
        return employeeService.update(employeeReq);
    }

    @DeleteMapping("{id}")
    public EmployeeRes delete(@PathVariable(name = "id") Long id) {
        return employeeService.delete(id);
    }

}
