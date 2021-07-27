package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Employee;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee-api")
public class EmployeeController {

	@Autowired
	EmployeRepository employeRepository;

	@GetMapping("/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {

			employeeList =	employeRepository.findAll();
			if (employeeList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employeeList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(employeeList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-employee-by-name/{empName}")
	public Long getEmplolyeeIdForName(@PathVariable("empName") String empName) {
		Optional<Employee> employeeOptional = employeRepository.findByEmpName(empName);

		if (employeeOptional.isPresent()) {
			return employeeOptional.get().getEmpId();
		} else {
			return 0L;
		}
	}


	@GetMapping("/get-employee/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") long empId) {
		Optional<Employee> employeeOptional = employeRepository.findById(empId);

		if (employeeOptional.isPresent()) {
			return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create-employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee employee = null;
		try {
			Optional<Employee> optionalEmployee = employeRepository.findByEmpName(emp.getEmpName());
			if (optionalEmployee.isPresent()) {
				return new ResponseEntity<>(employee, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			employee = employeRepository
					.save(emp);
			return new ResponseEntity<>(employee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(employee, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-employee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Long empId, @RequestBody Employee employee) {
		Optional<Employee> optionalEmployee = employeRepository.findById(empId);

		if (optionalEmployee.isPresent()) {
			Employee empl_tobe_updated = optionalEmployee.get();
			empl_tobe_updated.setEmpName(employee.getEmpName());
			empl_tobe_updated.setEmpCampus(employee.getEmpCampus());
			empl_tobe_updated.setSpecialization(employee.getSpecialization());
			employeRepository.save(empl_tobe_updated);
			return new ResponseEntity<>(empl_tobe_updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete-employee/{empId}")
	public ResponseEntity deleteEmployee(@PathVariable("empId") Long empId) {
		Optional<Employee> optionalEmployee = employeRepository.findById(empId);

		if (optionalEmployee.isPresent()) {
			employeRepository.deleteById(empId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



}
