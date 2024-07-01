package com.example.jenkins.repository;

import com.example.jenkins.model.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee , Long> {

}
