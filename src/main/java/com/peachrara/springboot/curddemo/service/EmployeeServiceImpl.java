package com.peachrara.springboot.curddemo.service;

import com.peachrara.springboot.curddemo.dao.EmployeeDAO;
import com.peachrara.springboot.curddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findByID(int id) {
        return employeeDAO.findByID(id);
    }

    @Override
    @javax.transaction.Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @javax.transaction.Transactional
    public void deleteByID(int id) {
        employeeDAO.deleteByID(id);
    }
}
