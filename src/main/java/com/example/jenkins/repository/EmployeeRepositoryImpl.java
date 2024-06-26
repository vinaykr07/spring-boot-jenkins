package com.example.jenkins.repository;

import com.example.jenkins.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final List<Employee> empList = new ArrayList<>();

    @Override
    public Employee findById(Long id) {
        Optional<Employee> employee = empList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
        return employee.orElse(new Employee());
    }

    @Override
    public Employee save(Employee emp) {
        if(findById(emp.getId()).getId() == null)
            empList.add(emp);
        else {
            Employee fetchedEmp = findById(emp.getId());
            fetchedEmp.setName(emp.getName());
            fetchedEmp.setSalary(fetchedEmp.getSalary());
            fetchedEmp.setCity(emp.getCity());
            fetchedEmp.setDept(emp.getDept());
            return fetchedEmp;
        }
        return emp;
    }

    @Override
    public String delete(Long id) {
        Employee emp = findById(id);
        if(empList.remove(emp))
            return "Removed Employee!!";
        return "Employee not available!!";
    }

    @Override
    public List<Employee> getAll() {
        return empList;
    }

    public EmployeeRepositoryImpl(){
        empList.add(new Employee(2345L,"Vinay Kumar",1000.00,"Bara uni","DEV"));
    }
}
