package com.zichen.test;

import com.zichen.domain.Department;
import com.zichen.domain.Employee;
import com.zichen.service.DepartmentService;
import com.zichen.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void findAllDepartTest(){
        List<Department> all = departmentService.findAll();
        for(Department department : all){
            System.out.println(department);
        }
    }

    @Test
    public void findByIdDepartTest(){
        Department byId = departmentService.findById(1);
        System.out.println(byId);
    }

    @Test
    public void saveDepartTest() {
        Department department = new Department();
        department.setDepartName("人事部");
        department.setDepartManager("韦小宝");
        department.setManagerTel("18792751490");
        department.setManagerEmail("xiaobaowei@163.com");
        departmentService.save(department);
    }

    @Test
    public void updateDepartTest(){
        Department department = new Department();
        department.setDepartId(4);
        department.setDepartName("科技部");
        department.setDepartManager("傅斯斯");
        department.setManagerTel("18892750491");
        department.setManagerEmail("sisifu@163.com");
        departmentService.update(department);
    }


    @Test
    public void deleteDepartTest(){
        departmentService.delete(6);
    }

    @Test
    public void findAllEmployeeTest(){
        List<Employee> all = employeeService.findAll();
        for(Employee employee : all){
            System.out.println(employee);
        }
    }

    @Test
    public void findByIdEmployeeTest(){
        Employee byId = employeeService.findById(1);
        System.out.println(byId);
    }

    @Test
    public void saveEmployeeTest(){
        Employee employee = new Employee();
        employee.setEmpName("王健林");
        employee.setEmpDepartId(2);
        employee.setEmpPosition("销售经理");
        employee.setEmpStartDate("2015-09-10");
        employee.setEmpTel("18792750010");
        employeeService.save(employee);
    }

    @Test
    public void updateEmployeeTest(){
        Employee employee = new Employee();
        employee.setEmpId(6);
        employee.setEmpName("王菲");
        employee.setEmpDepartId(1);
        employee.setEmpPosition("销售经理");
        employee.setEmpStartDate("2016-10-10");
        employee.setEmpTel("18792750011");
        employeeService.update(employee);
    }

//    @Test
//    public void deleteEmployeeTest(){
//        employeeService.delete(7);
//    }


}
