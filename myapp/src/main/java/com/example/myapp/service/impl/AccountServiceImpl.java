package com.example.myapp.service.impl;

import com.example.myapp.DAO.AccountMapper;
import com.example.myapp.pojo.account;
import com.example.myapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
//再网上看到 好像是 service和controller和component 还有这个 都是没有本质区别的
@Repository
@Service
@Component
public class AccountServiceImpl implements AccountService {
    //这里就是需要把这个实现方法具体的写出来了,然后这里就需要加入注解了
    //这就是所谓的自动装配的功能吧
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public account loginIn(String user_name,String pwd){
        return accountMapper.getInfo(user_name,pwd);
    }
    public void Register(String user_name,String pwd){
        accountMapper.addAccount(user_name,pwd);
    }

}