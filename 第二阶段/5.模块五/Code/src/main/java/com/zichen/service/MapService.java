package com.zichen.service;

import com.zichen.common.ServerResponse;
import com.zichen.vo.ProvinceVo;

import java.util.List;

public interface MapService {
    ServerResponse<List<ProvinceVo>> getMapData();
}
