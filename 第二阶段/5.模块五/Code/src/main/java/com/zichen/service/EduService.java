package com.zichen.service;

import com.zichen.common.ServerResponse;

import java.util.Map;

public interface EduService {
    ServerResponse<Map<String, Object>> getEduData();
}
