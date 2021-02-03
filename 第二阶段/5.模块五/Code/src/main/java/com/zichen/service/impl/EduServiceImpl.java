package com.zichen.service.impl;

import com.zichen.common.ServerResponse;
import com.zichen.mapper.EduMapper;
import com.zichen.service.EduService;
import com.zichen.vo.ConvertVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EduServiceImpl implements EduService {


    @Autowired
    private EduMapper eduMapper;

    @Override
    public ServerResponse<Map<String, Object>> getEduData() {
        List<ConvertVo> dataList = eduMapper.getEduCount();
        Map<String, Object> map = new HashMap<>();
        List<String> nameList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();

        for(ConvertVo cv : dataList){
            nameList.add(cv.getName());
            valueList.add(cv.getValue());
        }
        map.put("names", nameList);
        map.put("valueList", valueList);
        map.put("eduData", dataList);

        return ServerResponse.createdBySuccessData(map);
    }
}
