package com.demo.repository;

import java.util.Optional;

import com.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeRepository extends JpaRepository<Employee, Long> {
    Optional <Employee> findByEmpName(String empName);
}
