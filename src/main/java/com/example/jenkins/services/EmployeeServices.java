package com.example.jenkins.services;

import com.example.jenkins.model.Employee;
import com.example.jenkins.repository.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepositoryImpl repository;

    public Employee findById(Long id) {
        return repository.findById(id);
    }

    public Employee save(Employee emp) {
        return repository.save(emp);
    }

    public String delete(Long id) {
       return repository.delete(id);
    }

    public List<Employee> getAll() {
        return repository.getAll();
    }
}
