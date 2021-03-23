package com.peachrara.springboot.curddemo.rest;

import com.peachrara.springboot.curddemo.entity.Employee;
import com.peachrara.springboot.curddemo.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID) {
        Employee employee = employeeRepository.findByID(employeeID);
        if (employee == null) {
            throw new RuntimeException(("Employee id not found: " + employeeID));
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        employeeRepository.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID) {
        Employee employee = employeeRepository.findByID(employeeID);
        if (employee == null) {
            throw new RuntimeException("Employee id not found: " + employeeID);
        }
        employeeRepository.deleteByID(employeeID);
        return "Delete success.";
    }
}
