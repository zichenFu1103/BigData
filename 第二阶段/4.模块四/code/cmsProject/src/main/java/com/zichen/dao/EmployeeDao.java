package com.zichen.dao;

import com.zichen.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();

    public Employee findById(Integer id);

    public void save(Employee employee);

    public void update(Employee employee);

    public void delete(Integer[] ids);
}
