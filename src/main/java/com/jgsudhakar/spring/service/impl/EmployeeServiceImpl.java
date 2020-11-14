package com.jgsudhakar.spring.service.impl;

import com.jgsudhakar.spring.entity.EmployeeEntity;
import com.jgsudhakar.spring.repository.EmployeeRepository;
import com.jgsudhakar.spring.rest.dto.request.EmployeeReq;
import com.jgsudhakar.spring.rest.dto.response.EmployeeRes;
import com.jgsudhakar.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.service.impl.EmployeeServiceImpl
 * @Date : 14/11/2020
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeRes> getEmpList() {
        return Optional.ofNullable(employeeRepository.findAll()).orElse(Collections.emptyList()).
                stream().map(employeeEntity -> {
                    return empRes(employeeEntity);
        }).collect(toList());
    }

    @Override
    public EmployeeRes save(EmployeeReq employeeReq) {
        EmployeeEntity save = employeeRepository.
                    save(
                            new EmployeeEntity(
                                    employeeReq.getEmpId(), employeeReq.getEmployeeName(),
                                    employeeReq.getEmpLastName())
                    );
        return empRes(save);
    }

    @Override
    public EmployeeRes update(EmployeeReq employeeReq) {
        return save(employeeReq);
    }

    @Override
    public EmployeeRes get(Long empId) {
        Optional<EmployeeEntity> byId = employeeRepository.findById(empId);
        if(byId.isPresent()) {
            return empRes(byId.get());
        }
        return null;
    }

    @Override
    public EmployeeRes delete(Long empId) {
        Optional<EmployeeEntity> byId = employeeRepository.findById(empId);
        if(byId.isPresent()) {
            employeeRepository.deleteById(empId);
            return empRes(byId.get());
        }
        return null;
    }

    private EmployeeRes empRes (EmployeeEntity employeeEntity) {
        return new EmployeeRes(
                employeeEntity.getId(),employeeEntity.getEmpFirstName(),
                employeeEntity.getEmpLastName());
    }
}
