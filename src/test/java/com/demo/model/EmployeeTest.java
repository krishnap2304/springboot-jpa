package com.demo.model;

import org.junit.Test;

public class EmployeeTest {
    Employee employee = new Employee();

    Employee employee1 = new Employee("testemp","bengaluru","cloud","Bengaluru");
    @Test
    public void test(){
        employee1.getEmpId();
        employee1.getEmpName();
        employee1.getEmpCampus();
        employee1.getEmpLocation();
        employee1.equals(employee1);
        employee1.toString();
        employee1.hashCode();
    }
}
