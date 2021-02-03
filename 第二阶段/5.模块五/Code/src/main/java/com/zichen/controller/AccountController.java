package com.zichen.controller;

import com.zichen.common.ResponseCode;
import com.zichen.common.ServerResponse;
import com.zichen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/transfer.do")
    @ResponseBody //返回数据类型为json格式
    public ServerResponse accountTransfer(String inName, String outName, double money){
        int status = accountService.transfer(inName, outName, money);
        if(status == ResponseCode.SUCCESS.getCode()){
            return ServerResponse.createdBySuccessMsg("转账成功...");
        }else {
            return ServerResponse.createdByErrorMsg("转账失败...");
        }
    }

}
