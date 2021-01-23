package com.zichen.controller;

import com.zichen.domain.Employee;
import com.zichen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Employee> all = employeeService.findAll();
        model.addAttribute("list", all);
        return "list";
    }

    @RequestMapping("/save")
    public String save(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/findAll";
    }

    @RequestMapping("/delete")
    public String deleteBatch(Integer[] ids){
        employeeService.delete(ids);
        //跳转到findAll方法
        return "redirect:/employee/findAll";
    }

    @RequestMapping("/findById")
    public String findById(Integer empId, Model model){
        Employee employee = employeeService.findById(empId);
        model.addAttribute("employee", employee);
        return "update";
    }

    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.update(employee);
        //跳转到findAll方法
        return "redirect:/employee/findAll";
    }


}
