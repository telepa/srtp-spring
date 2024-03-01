package com.example.myapp.service;
import com.example.myapp.pojo.account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    public account loginIn(String user_name,String pwd);
    public void Register(String user_name,String pwd);
}
