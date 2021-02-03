package com.zichen.service;

import com.zichen.common.ServerResponse;

import java.util.Map;

public interface IndustryService {
    ServerResponse<Map<String, Object>> countCityData();

    ServerResponse<Map<String, Object>> getTopIndustries();

    ServerResponse<Map<String, Object>> industryCompare();

    ServerResponse<Map<String, Object>> getSalaryTop10();
}
