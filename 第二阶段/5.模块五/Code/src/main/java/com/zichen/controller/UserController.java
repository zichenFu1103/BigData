package com.zichen.controller;

import com.github.pagehelper.PageInfo;
import com.zichen.common.Constant;
import com.zichen.common.ResponseCode;
import com.zichen.common.ServerResponse;
import com.zichen.model.User;
import com.zichen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@Transactional
public class UserController {

    @Autowired
    private UserService userService;

    //用户登陆
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        //调用service登陆方法，返回一个ServerResponse
        ServerResponse<User> response = userService.login(username, password);
        //判断是否登陆成功，如果成功把当前用户放到session
        if(response.getStatus() == ResponseCode.SUCCESS.getCode()){
            session.setAttribute(Constant.CURRENT_USER,response.getData());
        }
        return response;
    }

    //分页
    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        ServerResponse<PageInfo> response = userService.getUsers(pageNum, pageSize);
        return response;
    }


    //添加用户
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> add(User user){
        return userService.add(user);
    }

    //删除用户
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delete(int id){
        return userService.deleteByPrimaryKey(id);
    }

    //用户退出
    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        try {
            session.removeAttribute(Constant.CURRENT_USER);
            return ServerResponse.createdBySuccessMsg("退出成功...");
        }catch(Exception e){
            return  ServerResponse.createdByErrorMsg("退出失败...");
        }
    }

    //根据用户ID查找
    @RequestMapping(value = "/findById.do", method = RequestMethod.POST)
    @ResponseBody
     public ServerResponse<User> findById(Integer userId, Model model){
         ServerResponse<User> response = userService.getInfo(userId);
         User user = response.getData();
         model.addAttribute("user", user);
         return response;
     }

     @RequestMapping(value = "/update.do", method = RequestMethod.POST)
     @ResponseBody
    public ServerResponse<String> update(User user){
        ServerResponse<String> response = userService.update(user);
        return response;
    }

}
