package com.example.jenkins.services;

import com.example.jenkins.model.Employee;
import com.example.jenkins.repository.EmployeeRepository;
import com.example.jenkins.repository.EmployeeRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    Logger log = LoggerFactory.getLogger(EmployeeServices.class);

    @Autowired
    EmployeeRepository repository;

    public Employee findById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        return employee.orElse(new Employee());
    }

    public Employee save(Employee emp) {
        return repository.save(emp);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }
}
