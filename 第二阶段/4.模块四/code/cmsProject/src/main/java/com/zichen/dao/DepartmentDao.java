package com.zichen.dao;

import com.zichen.domain.Department;

import java.util.List;

public interface DepartmentDao {
    public List<Department> findAll();

    public Department findById(Integer id);

    public void save(Department department);

    public void update(Department department);

    public void delete(Integer id);
}
