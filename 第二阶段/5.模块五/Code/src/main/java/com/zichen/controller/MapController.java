package com.zichen.controller;

import com.zichen.common.ServerResponse;
import com.zichen.service.MapService;
import com.zichen.vo.ProvinceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/map")
public class MapController {

    @Autowired
    private MapService mapService;

    @RequestMapping(value = "/mapData.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<ProvinceVo>> countProvinceData(){
        ServerResponse<List<ProvinceVo>> response = mapService.getMapData();
        return response;
    }
}
