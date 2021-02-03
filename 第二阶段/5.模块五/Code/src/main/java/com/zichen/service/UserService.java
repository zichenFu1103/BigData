package com.zichen.service;

import com.github.pagehelper.PageInfo;
import com.zichen.common.ServerResponse;
import com.zichen.model.User;

public interface UserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<PageInfo> getUsers(int pageNum, int pageSize);

    ServerResponse<String> add(User user);

    ServerResponse<String> deleteByPrimaryKey(int id);


    ServerResponse<User> getInfo(int userId);

    ServerResponse<String> update(User user);
}
