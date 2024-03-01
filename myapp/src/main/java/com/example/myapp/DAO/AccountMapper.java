package com.example.myapp.DAO;

import com.example.myapp.pojo.account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountMapper {
    account getInfo(String user_name,String pwd);
    void addAccount(String user_name,String pwd);
}
