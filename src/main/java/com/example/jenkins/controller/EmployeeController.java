package com.example.jenkins.controller;

import com.example.jenkins.model.Employee;
import com.example.jenkins.services.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        log.info("Fetching All Employee !!");
        List<Employee> empList = employeeServices.getAll();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        log.info("Fetching Employee with emp id = {}",id);
        Employee emp = employeeServices.findById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee emp){
        log.info("Saving Employee in DB {} ",emp);
        Employee emp2 = employeeServices.save(emp);
        return new ResponseEntity<>(emp2,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        log.info("Deleting Employee by id {}",id);
        employeeServices.deleteById(id);
    }

}
