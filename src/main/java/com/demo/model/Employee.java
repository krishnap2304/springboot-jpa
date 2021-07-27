package com.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {
	public Employee(){

	}
	public Employee(String empName, String empCampus, String specialization, String empLocation) {
		this.empName = empName;
		this.empCampus = empCampus;
		this.specialization = specialization;
		this.empLocation = empLocation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;

	private String empName;

	private String empCampus;

	private String specialization;

	private String empLocation;


	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCampus() {
		return empCampus;
	}

	public void setEmpCampus(String empCampus) {
		this.empCampus = empCampus;
	}

	public String getSpecialization() {
		return specialization;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return empId == employee.empId && empName.equals(employee.empName) && empCampus.equals(employee.empCampus) && specialization.equals(employee.specialization) && empLocation.equals(employee.empLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, empCampus, specialization, empLocation);
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}


}
