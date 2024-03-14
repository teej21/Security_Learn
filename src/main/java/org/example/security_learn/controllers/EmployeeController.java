package org.example.security_learn.controllers;

import org.example.security_learn.entities.Employee;
import org.example.security_learn.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * - get all employees
     * - get by ID
     * - add new employee
     * - update employee
     * - delete employee
     */
//endpoint for http://localhost:8080/employees
    @GetMapping("")
    public String home() {
        return "Welcome to the employee management system!";
    }


    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee + " - added";
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee + " - updated";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        employeeService.deleteById(id);
        return "Employee with id " + id + " - deleted";
    }
}
