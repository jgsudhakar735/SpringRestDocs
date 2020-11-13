package com.jgsudhakar.spring.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.rest.dto.request.EmployeeReq
 * @Date : 12/11/2020
 */

public class EmployeeRes implements Serializable {
    
    private Long empId;

    private String employeeName;

    private String employeeDepartment;

    public EmployeeRes() {
    }

    public EmployeeRes(Long empId, String employeeName, String employeeDepartment) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}
