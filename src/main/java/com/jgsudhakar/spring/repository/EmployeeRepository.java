package com.jgsudhakar.spring.repository;

import com.jgsudhakar.spring.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.mq.repository.EmployeeRepository
 * @Date : 13/11/2020
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
