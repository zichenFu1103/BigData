package com.zichen.service.impl;

import com.zichen.common.CityProvinceConverter;
import com.zichen.common.ServerResponse;
import com.zichen.mapper.MapMapper;
import com.zichen.service.MapService;
import com.zichen.vo.CityVo;
import com.zichen.vo.ProvinceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {


    @Autowired
    private MapMapper mapMapper;

    @Override
    public ServerResponse<List<ProvinceVo>> getMapData() {
        //每个省有哪学城市
        List<ProvinceVo> provinceCityList = mapMapper.getProvinceCity();
        //每个城市的招聘人数
        List<CityVo> cityList = mapMapper.getCityNum();
        //
        List<ProvinceVo> provinceVos = CityProvinceConverter.convert(cityList, provinceCityList);

        return ServerResponse.createdBySuccessData(provinceVos);
    }
}
