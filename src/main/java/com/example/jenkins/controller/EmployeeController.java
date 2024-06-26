package com.example.jenkins.controller;

import com.example.jenkins.model.Employee;
import com.example.jenkins.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> empList = employeeServices.getAll();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Employee emp = employeeServices.findById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee emp){
        Employee emp2 = employeeServices.save(emp);
        return new ResponseEntity<>(emp2,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String msg = employeeServices.delete(id);
        return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
    }

}
