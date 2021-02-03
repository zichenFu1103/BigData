package com.zichen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zichen.common.Constant;
import com.zichen.common.ResponseCode;
import com.zichen.common.ServerResponse;
import com.zichen.mapper.UserMapper;
import com.zichen.model.User;
import com.zichen.service.UserService;
import com.zichen.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        //检查用户名是否存在
        int resultCount = userMapper.checkUserName(username);
        if(resultCount == 0){
            return ServerResponse.createdByErrorMsg("用户不存在...");
        }
        //使用MD5加密
        String md5Password = MD5Util.MD5EncodeUtf8(password);

        //调用Mapper登陆
        User user = userMapper.selectLogin(username, md5Password);
        if(user == null){
            return ServerResponse.createdByErrorMsg("密码错误...");
        }

        //
        user.setPassword(StringUtils.EMPTY);

        return ServerResponse.createdBySuccessDataMsg("登陆成功...", user);

    }

    @Override
    public ServerResponse<PageInfo> getUsers(int pageNum, int pageSize) {
        //给分页助手设置pageNum和pageSize
        PageHelper.startPage(pageNum, pageSize);

        //查询用户
        List<User> list = userMapper.userList();

        //创建pageInfo，把查询到的list方法pageInfo
        PageInfo pageInfo = new PageInfo(list);
        return ServerResponse.createdBySuccessData(pageInfo);
    }

    @Override
    public ServerResponse<String> add(User user) {
        //校验用户名
        ServerResponse<String> stringServerResponse = this.checkValid(user.getUsername(), Constant.USERNAME);
        if(stringServerResponse.getStatus() != ResponseCode.SUCCESS.getCode()){
            return stringServerResponse;
        }
        //校验邮箱
        stringServerResponse = this.checkValid(user.getEmail(), Constant.EMAIL);
        if(stringServerResponse.getStatus() != ResponseCode.SUCCESS.getCode()){
            return stringServerResponse;
        }

        //md5对密码加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        //添加到数据库 resultCount==1 插入成功
        int resultCount = userMapper.insertUser(user);
        if(resultCount == 0){
            return ServerResponse.createdByErrorMsg("添加失败...");
        }
        return ServerResponse.createdBySuccessMsg("添加成功...");
    }

    //校验用户名，邮箱
    public ServerResponse<String> checkValid(String str, String type){
        if(StringUtils.isNoneBlank(type)){
            if(Constant.USERNAME.equals(type)){
                int i = userMapper.checkUserName(str);
                if(i > 0){
                    return ServerResponse.createdByErrorMsg("用户名已经存在...");
                }
            }

            if(Constant.EMAIL.equals(type)){
                int i = userMapper.checkEmail(str);
                if(i > 0){
                    return ServerResponse.createdByErrorMsg("邮箱已经存在...");
                }
            }
        }
        return ServerResponse.createdBySuccessMsg("校验成功");
    }

    //删除用户
    @Override
    public ServerResponse<String> deleteByPrimaryKey(int id) {
        //判断是否存在，获取用户信息
        ServerResponse<User> information = this.getInfo(id);
        User user = information.getData();
        //不存在，返回失败
        if(user == null){
            return ServerResponse.createdByErrorMsg("删除的用户不存在...");
        }
        //存在，删除。得到返回值，count==1，成功
        int count = userMapper.deleteByPrimaryKey(id);
        if(count > 0){
            return ServerResponse.createdBySuccessMsg("删除成功...");
        }
        return ServerResponse.createdByErrorMsg("删除失败...");
    }

    //根据用户的id获取用户信息
    @Override
    public ServerResponse<User> getInfo(int userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if(user != null){
            return ServerResponse.createdBySuccessData(user);
        }
        return  ServerResponse.createdByErrorMsg("用户不存在");
    }

    @Override
    public ServerResponse<String> update(User user) {
        User oldUser = userMapper.selectByPrimaryKey(user.getId());
        String oldName = oldUser.getUsername();
        String newName = user.getUsername();
        if(StringUtils.isNoneBlank(newName)){
            int i = userMapper.checkUserName(newName);
            if(i > 0 && !oldName.equals(newName)){
                return ServerResponse.createdByErrorMsg("用户名已存在");
            }
        }

        String oldEmail = oldUser.getEmail();
        String newEmail = user.getEmail();
        if(StringUtils.isNoneBlank(newEmail)){
            int i = userMapper.checkEmail(newEmail);
            if(i > 0 && !oldEmail.equals(newEmail)){
                return ServerResponse.createdByErrorMsg("邮箱已存在");
            }
        }

        int i = userMapper.update(user);
        if(i > 0){
            return ServerResponse.createdBySuccessMsg("更新成功");
        }
        return ServerResponse.createdByErrorMsg("更新失败");
    }

}
