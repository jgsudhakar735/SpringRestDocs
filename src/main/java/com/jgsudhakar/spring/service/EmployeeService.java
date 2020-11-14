package com.jgsudhakar.spring.service;


import com.jgsudhakar.spring.rest.dto.request.EmployeeReq;
import com.jgsudhakar.spring.rest.dto.response.EmployeeRes;

import java.util.List;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.mq.services.imple.EmployeeService
 * @Date : 13/08/2020
 */
public interface EmployeeService  {

    List<EmployeeRes> getEmpList();

    EmployeeRes save(EmployeeReq employeeReq);

    EmployeeRes update(EmployeeReq employeeReq);

    EmployeeRes get(Long empId);

    EmployeeRes delete(Long empId);
}
