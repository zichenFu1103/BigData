package com.zichen.controller;

import com.zichen.domain.Department;
import com.zichen.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/findById")
    public String findById(Integer departId, Model model){
        Department department = departmentService.findById(departId);
        model.addAttribute("department", department);
        return "showDepartment";
    }
}
