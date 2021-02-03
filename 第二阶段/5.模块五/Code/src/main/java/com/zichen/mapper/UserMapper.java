package com.zichen.mapper;

import com.zichen.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public int checkUserName(String username);

    public User selectLogin(@Param("username") String username, @Param("password") String password) ;

    List<User> userList();

    int checkEmail(String str);

    int insertUser(User user);

    int deleteByPrimaryKey(int id);

    User selectByPrimaryKey(int userId);

    int update(User user);
}
