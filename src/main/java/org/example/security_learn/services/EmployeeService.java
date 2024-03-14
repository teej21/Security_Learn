package org.example.security_learn.services;

import org.example.security_learn.entities.Employee;
import org.example.security_learn.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        return employeeRepository.findById(id).get();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteById(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}
