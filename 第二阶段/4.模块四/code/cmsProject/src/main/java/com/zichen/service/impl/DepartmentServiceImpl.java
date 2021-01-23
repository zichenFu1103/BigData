package com.zichen.service.impl;

import com.zichen.dao.DepartmentDao;
import com.zichen.domain.Department;
import com.zichen.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
        List<Department> all = departmentDao.findAll();
        return all;
    }

    @Override
    public Department findById(Integer id) {
        Department department = departmentDao.findById(id);
        return department;
    }

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(Integer id) {
        departmentDao.delete(id);
    }
}
