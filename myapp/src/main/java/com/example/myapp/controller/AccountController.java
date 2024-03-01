package com.example.myapp.controller;

import com.example.myapp.pojo.account;
import com.example.myapp.service.AccountService;
import com.example.myapp.service.FollowUpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/initial")
    public String initial(){
        return "initial";
    }
    @RequestMapping("/login")
    public String show(){
        return "login";
    }
    @RequestMapping(value="/loginIn",method = RequestMethod.POST)
    public String login(String user_name,String pwd){
        account myaccount=accountService.loginIn(user_name,pwd);
        if(myaccount!=null){
            return "success";
        }else return "error";
    }
    @RequestMapping(value="/Register",method =RequestMethod.POST)
    public String RegisterShow(){
        return "Register";
    }
    @RequestMapping(value="/RegisterIn",method =RequestMethod.POST)
    public String Resgister(String user_name,String pwd){
        accountService.Register(user_name,pwd);
        return  "successR";
    }
}
