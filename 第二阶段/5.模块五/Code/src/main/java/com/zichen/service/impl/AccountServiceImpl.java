package com.zichen.service.impl;

import com.zichen.mapper.AccountMapper;
import com.zichen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional //事务控制
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int transfer(String inName, String outName, double money) {
        try{
            accountMapper.transferIn(inName, money);
            accountMapper.transferOut(outName, money);
            return 0;
        }catch (Exception e){
            System.out.println(e);
            return 1;
        }
    }
}
