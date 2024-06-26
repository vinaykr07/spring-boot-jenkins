package com.example.jenkins.repository;

import com.example.jenkins.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {

    Employee findById(Long id);

    Employee save(Employee emp);

    String delete(Long id);

    List<Employee> getAll();

}
