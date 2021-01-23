package com.zichen.service.impl;

import com.zichen.dao.EmployeeDao;
import com.zichen.domain.Employee;
import com.zichen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        List<Employee> all = employeeDao.findAll();
        return all;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeDao.findById(id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(Integer[] ids) {
        employeeDao.delete(ids);
    }
}
