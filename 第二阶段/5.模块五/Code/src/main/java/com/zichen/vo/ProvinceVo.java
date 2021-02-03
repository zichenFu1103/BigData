package com.zichen.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceVo {
    @JsonIgnore
    private int pid;
    private String name;
    private long value;
    @JsonIgnore
    private List<CityVo> city;
}
