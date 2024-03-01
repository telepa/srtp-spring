package com.example.myapp.controller;

import com.example.myapp.pojo.follow_up_info;
import com.example.myapp.service.FollowUpInfoService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FollowUpInfoController {
    @Autowired
    FollowUpInfoService followUpInfoService;
    @RequestMapping("/FollowSearch")
    public String show(){return "FollowSearch";}
    @RequestMapping(value="/FollowSearchWin",method = RequestMethod.POST)
    public String showSearch(String f_id,int id,java.sql.Date f_date){
        follow_up_info mySearch= followUpInfoService.getRecord(f_id,id,f_date);
        if(mySearch!=null){
            return "SearchWin";
        }else return "SearchError";
    }
    @RequestMapping(value="/InsertRecords",method = RequestMethod.POST)
    public String InsertingAns(String f_id,int id,String classify,java.sql.Date f_date,String question,String ans,int score){
        followUpInfoService.InsertRecord(f_id,id,classify,f_date,question,ans,score);
        return "InsertSuccess";
    }
    @RequestMapping(value = "Restart",method = RequestMethod.POST)
    public String DeleteRecords(int id,java.sql.Date f_date){
        followUpInfoService.DeleteRecords(id,f_date);
        return "DeleteSuccess";
    }
}

