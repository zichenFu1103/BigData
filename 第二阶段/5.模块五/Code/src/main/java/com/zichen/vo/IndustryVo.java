package com.zichen.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndustryVo {
    private String positionName;
    private long number;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date theDay;
}
