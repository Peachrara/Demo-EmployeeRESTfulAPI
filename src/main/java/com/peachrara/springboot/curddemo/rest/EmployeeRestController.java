package com.peachrara.springboot.curddemo.rest;

import com.peachrara.springboot.curddemo.entity.Employee;
import com.peachrara.springboot.curddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID) {
        Employee employee = employeeService.findByID(employeeID);
        if (employee == null) {
            throw new RuntimeException(("Employee id not found: " + employeeID));
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID) {
        Employee employee = employeeService.findByID(employeeID);
        if (employee == null) {
            throw new RuntimeException("Employee id not found: " + employeeID);
        }
        employeeService.deleteByID(employeeID);
        return "Delete success.";
    }
}
