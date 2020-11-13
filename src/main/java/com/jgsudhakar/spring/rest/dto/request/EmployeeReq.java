package com.jgsudhakar.spring.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.rest.dto.request.EmployeeReq
 * @Date : 12/11/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReq implements Serializable {

    private Long empId;

    private String employeeName;

    private String employeeDepartment;
}
