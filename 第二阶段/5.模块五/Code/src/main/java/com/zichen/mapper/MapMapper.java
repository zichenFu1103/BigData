package com.zichen.mapper;

import com.zichen.vo.CityVo;
import com.zichen.vo.ProvinceVo;

import java.util.List;

public interface MapMapper {
    List<ProvinceVo> getProvinceCity();

    List<CityVo> getCityNum();
}
