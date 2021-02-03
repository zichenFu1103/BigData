package com.zichen.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //提供了 get，set，toString方法
@AllArgsConstructor //全参构造
@NoArgsConstructor //无参构造
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd : HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd : HH:mm:ss")
    private Date updateTime;


}
