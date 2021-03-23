package com.peachrara.springboot.curddemo.service;

import com.peachrara.springboot.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findByID(int id);
    public void save(Employee employee);
    public void deleteByID(int id);
}
