package com.zichen.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    //传入钱
    public void transferIn(@Param("name") String name, @Param("money") double money);

    //穿出钱
    public void transferOut(@Param("name") String name, @Param("money") double money);
}
