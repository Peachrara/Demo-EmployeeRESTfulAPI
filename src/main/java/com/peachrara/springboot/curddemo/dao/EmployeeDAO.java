package com.peachrara.springboot.curddemo.dao;

import com.peachrara.springboot.curddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findByID(int id);
    public void save(Employee employee);
    public void deleteByID(int id);
}
