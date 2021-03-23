package com.peachrara.springboot.curddemo.service;

import com.peachrara.springboot.curddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeRepository {

    // For Dao
//    private EmployeeDAO employeeDAO;

//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeJpaDAOImpl") EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    // For Spring Data repo
    private com.peachrara.springboot.curddemo.dao.EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(com.peachrara.springboot.curddemo.dao.EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findByID(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }
        else {
            throw new RuntimeException();
        }
        return employee;
    }

    @Override
    @javax.transaction.Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @javax.transaction.Transactional
    public void deleteByID(int id) {
        employeeRepository.deleteById(id);
    }
}
