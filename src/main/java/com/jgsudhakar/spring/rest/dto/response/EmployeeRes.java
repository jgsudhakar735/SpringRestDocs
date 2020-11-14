package com.jgsudhakar.spring.rest.dto.response;

import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.rest.dto.request.EmployeeReq
 * @Date : 12/11/2020
 */

public class EmployeeRes implements Serializable {
    
    private Long empId;

    private String employeeName;

    private String empLastName;

    public EmployeeRes() {
    }

    public EmployeeRes(Long empId, String employeeName, String empLastName) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.empLastName = empLastName;
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

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }
}
