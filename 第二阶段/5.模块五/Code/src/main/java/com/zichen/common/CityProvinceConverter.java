package com.zichen.common;

import com.zichen.vo.CityVo;
import com.zichen.vo.ProvinceVo;

import java.util.ArrayList;
import java.util.List;

public class CityProvinceConverter {
    public static List<ProvinceVo> convert(List<CityVo> cityList, List<ProvinceVo> provinceCityList) {

        flag:for(ProvinceVo pv : provinceCityList){
            long sumCount = 0;
            String provinceName = pv.getName();
            List<CityVo> pCityList = pv.getCity();
            ArrayList<String> cityNameList = new ArrayList<>();
            for(CityVo cv : pCityList){
                cityNameList.add(cv.getCname());
            }

            for(CityVo cv : cityList){
                //判断有些有些省的名称不要是 北京  上海  还有天津 重庆...
                if(provinceName.equals("北京") && cv.getCname().equals("北京")){
                    //给北京设置招聘人数
                    pv.setValue(cv.getNumber());
                    continue flag;
                } else if(provinceName.equals("上海") && cv.getCname().equals("上海")){
                    pv.setValue(cv.getNumber());
                    continue flag;
                } else if(provinceName.equals("天津") && cv.getCname().equals("天津")){
                    pv.setValue(cv.getNumber());
                    continue flag;
                } else if(provinceName.equals("重庆") && cv.getCname().equals("重庆")){
                    pv.setValue(cv.getNumber());
                    continue flag;
                } else {
                    //如果省份的名称集合包含城市的名字,累加sumCount 设置给provinceVo
                    if(cityNameList.contains(cv.getCname())){
                        sumCount += cv.getNumber();
                    }
                }
            }
            pv.setValue(sumCount);
        }
        return provinceCityList;
    }
}
