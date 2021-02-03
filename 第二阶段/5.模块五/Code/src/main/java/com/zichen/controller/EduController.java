package com.zichen.controller;

import com.zichen.common.ServerResponse;
import com.zichen.service.EduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/edu")
public class EduController {

    @Autowired
    private EduService eduService;

    @RequestMapping("/eduCount.do")
    @ResponseBody
    public ServerResponse<Map<String, Object>> getEduCount(){
        ServerResponse<Map<String, Object>> eduData = eduService.getEduData();
        return eduData;
    }
}
