package com.zichen.mapper;

import com.zichen.vo.ConvertVo;
import com.zichen.vo.IndustryVo;
import com.zichen.vo.SalaryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndustryMapper {
    List<ConvertVo> countCityPosition();

    List<IndustryVo> getTopIndustries();

    List<IndustryVo> getIndustriesData(@Param(value = "industryName") String industryName,
                                       @Param(value = "startDate") String startDate,
                                       @Param(value = "endDate") String endDate);

    List<SalaryVo> countSalaryTop();
}
