package com.example.jenkins.controller;


import com.example.jenkins.model.Employee;
import com.example.jenkins.services.EmployeeServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @MockBean
    EmployeeServices employeeServices;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_saveEmp_returnCreatedEmp() throws Exception{
        Employee created = new Employee(9876L,"Varika Rastogi",1009.00,"Meeruth","QA");
        when(employeeServices.save(created)).thenReturn(created);

        mockMvc.perform(post("/emp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(created)))
                .andExpect(status().isCreated());

    }
    @Test
    public void test_getEmpById_returnEmp() throws Exception{
        Employee created = new Employee(9876L,"Varika Rastogi",1009.00,"Meeruth","QA");
        when(employeeServices.findById(9876L)).thenReturn(created);

        mockMvc.perform(get("/emp/{id}",9876L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Varika Rastogi"));
    }
    @Test
    public void test_getAllEmp_returnAllEmp() throws Exception{
        Employee emp1 = new Employee(9876L,"Varika Rastogi",1009.00,"Meeruth","QA");
        Employee emp2 = new Employee(8765L,"Monika Shekhawat",1008.00,"Faridabad","DEV");
        List<Employee> empList = Arrays.asList(emp1,emp2);

        when(employeeServices.getAll()).thenReturn(empList);

        mockMvc.perform(get("/emp")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.[1].name").value("Monika Shekhawat"));

    }
    @Test
    public void test_deleteEmp_returnMessage() throws Exception{
        Employee emp2 = new Employee(8765L,"Monika Shekhawat",1008.00,"Faridabad","DEV");
       doNothing().when(employeeServices).deleteById(8765L);

        mockMvc.perform(delete("/emp/{id}",8765L)
                        .contentType(MediaType.APPLICATION_JSON))
                         .andExpect(status().isOk());

    }

}
