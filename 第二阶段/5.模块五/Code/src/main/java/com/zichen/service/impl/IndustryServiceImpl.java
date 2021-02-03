package com.zichen.service.impl;

import com.zichen.common.Constant;
import com.zichen.common.ServerResponse;
import com.zichen.mapper.IndustryMapper;
import com.zichen.service.IndustryService;
import com.zichen.vo.ConvertVo;
import com.zichen.vo.IndustryVo;
import com.zichen.vo.SalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryMapper industryMapper;

    @Override
    public ServerResponse<Map<String, Object>> countCityData() {
        List<ConvertVo> cityPositionList = industryMapper.countCityPosition();

        Map<String, Object> map = new HashMap<>();

        //cityNameList:存放城市名字；thirdList：前三名城市数据；dataList：存放前10名城市数据
        List<String> cityNameList = new ArrayList<>();
        List<ConvertVo> thirdList = new ArrayList<>();
        List<ConvertVo> dataList = new ArrayList<>();

        for(ConvertVo cv: cityPositionList){
            cityNameList.add(cv.getName());

            if(thirdList.size() < 3){
                thirdList.add(cv);
            }

            dataList.add(cv);
        }

        map.put("cityNameList", cityNameList);
        map.put("thirdList",thirdList);
        map.put("dataList",dataList);

        return ServerResponse.createdBySuccessData(map);
    }

    @Override
    public ServerResponse<Map<String, Object>> getTopIndustries() {
        List<IndustryVo> topIndustries = industryMapper.getTopIndustries();

        Map<String, Object> map = new HashMap<>();

        List<String> industryNames = new ArrayList<>();
        List<Long> countList = new ArrayList<>();

        for(IndustryVo iv : topIndustries){
            industryNames.add(iv.getPositionName());
            countList.add(iv.getNumber());
        }

        map.put("names", industryNames);
        map.put("count", countList);

        return ServerResponse.createdBySuccessData(map);
    }

    @Override
    public ServerResponse<Map<String, Object>> industryCompare() {
        Map<String, Object> map = new HashMap<>();

        for(String industryName : Constant.INDUSTRIES){
            List<Long> count = new ArrayList<>();
            List<IndustryVo> dataList = industryMapper.getIndustriesData(industryName, Constant.START_DATE, Constant.END_DATE);

            for(IndustryVo iv : dataList){
                count.add(iv.getNumber());
            }

            if(industryName.equals(Constant.INDUSTRIES[0])){
                map.put("tech", count);
            }else if(industryName.equals(Constant.INDUSTRIES[1])) {
                map.put("operator", count);
            }else {
                map.put("sell", count);
            }
        }
        map.put("nameList", Constant.INDUSTRIES);
        map.put("dateTime", Constant.DATE_TIME);
        return ServerResponse.createdBySuccessData(map);
    }

    @Override
    public ServerResponse<Map<String, Object>> getSalaryTop10() {
        //1.查询工资top10城市
        List<SalaryVo> list =  industryMapper.countSalaryTop();

        //2.创建map 封装所有数据
        Map<String,Object> map = new HashMap<>();

        //3.创建两个list  namesList 放行业名称   countList 行业数量
        List<String> cityList = new ArrayList<>();
        List<Double> salaryList = new ArrayList<>();

        //4.循环给list设置数据
        for (SalaryVo salaryVo : list) {
            cityList.add(salaryVo.getCityName());
            salaryList.add(salaryVo.getSalary());
        }

        //5.list存在map中
        map.put("names",cityList);
        map.put("count",salaryList);

        //6.map放到ServerResponse
        return ServerResponse.createdBySuccessData(map);
    }
}
