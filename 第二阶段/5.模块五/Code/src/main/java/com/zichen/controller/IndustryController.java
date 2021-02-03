package com.zichen.controller;

import com.zichen.common.ServerResponse;
import com.zichen.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;


    @RequestMapping(value = "/countCityPosition.do")
    @ResponseBody
    public ServerResponse<Map<String, Object>> countCityNums(){
        ServerResponse<Map<String, Object>> response = industryService.countCityData();
        return response;
    }

    @RequestMapping(value = "/industryTop.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String, Object>> getTopIndustries(){
        ServerResponse<Map<String, Object>> response = industryService.getTopIndustries();
        return response;
    }

    @RequestMapping(value = "/industryCompare.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String, Object>> compareIndustries(){
        ServerResponse<Map<String, Object>> response = industryService.industryCompare();
        return response;
    }

    @RequestMapping(value = "salaryTop.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String,Object>> getSalaryTop(){
        ServerResponse<Map<String,Object>> response =  industryService.getSalaryTop10();
        return response;
    }
}
