package com.demo.controller;


import com.demo.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.authentication.FormAuthConfig.springSecurity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeControllerTest {
    @Autowired
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        DefaultMockMvcBuilder builder = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext);
        this.mvc = builder.build();
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        String uri = "http://localhost:8080/employee-api/get-all-employees";
        MvcResult mvcResult = null;
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }

    @Test
    public void testGetEmployee() throws Exception {
        String uri = "/employee-api/get-employee/92";
        MvcResult mvcResult = null;
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        assertNotNull(content);
    }

    @Test
    public void testCreateEmployee() throws Exception {
        String uri = "/employee-api/create-employee";
        MvcResult mvcResult = null;
        String name = "TestEmpl"+ Math.random();

        Employee employee = getMockedEmployee(name);
        mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri,employee)
                .content(getContentAsString(employee))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertNotNull(mvcResult);
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.CREATED.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }

    private String getContentAsString(Employee employee) throws Exception {
        return new ObjectMapper().writeValueAsString(employee);
    }

    @Test
    public void tesUpdateEmployee() throws Exception {
        MvcResult mvcResult = null;
        Employee employee = getMockedEmployeeForUpdate();
        employee.setEmpId(91L);
        String uri = "/employee-api/update-employee"+employee.getEmpId();
        mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri, employee)
                .content("{ \"empName\": \"Bharat Arora\", \"empCampus\": \"Bengaluru\", \"empSpecialization\":\"Cloud Specialist\",\"empLocation\":\"Bengaluru\" }")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertNotNull(status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }


    Long getEmployeeForUpdate() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("ID===>"+restTemplate.getForObject("http://localhost:8080/employee-api/get-employee-by-name/TestEmp002",Long.class));
       return  restTemplate.getForObject("http://localhost:8080/employee-api/get-employee-by-name/TestEmp002",Long.class);
    }

    private Employee getMockedEmployee(String name) {
        return new Employee(name,"Bengaluru","ET","Bengaluru");
    }

    private Employee getMockedEmployeeForUpdate() {
        return new Employee("Bharat Arora","Bengaluru","ExpertInCloudTech","Bengaluru");
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        String uri = "/employee-api/delete-employee/106";
        MvcResult mvcResult = null;
        mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertNotNull(status);
    }
}