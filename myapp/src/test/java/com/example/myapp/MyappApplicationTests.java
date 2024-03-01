package com.example.myapp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.example.myapp.pojo.account;
import com.example.myapp.pojo.follow_up_info;
import com.example.myapp.service.AccountService;
import com.example.myapp.service.FollowUpInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyappApplicationTests {
    @Autowired
    AccountService accountService;
    @Autowired
    FollowUpInfoService followUpInfoService;
    @Test
    public void contextLoads() {
        account myaccount=accountService.loginIn("Alice","zju123456");
        System.out.println("该用户密码为：");
        if(myaccount!=null)System.out.println(myaccount.getPwd());
        //follow_up_info test
        java.util.Date tmpDate=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            tmpDate=sdf.parse("2023-09-12");
        }catch (ParseException e){
            e.printStackTrace();
        }
        Long time=tmpDate.getTime();
        System.out.println(time);
        java.sql.Date f_date=new java.sql.Date(time);
        follow_up_info myFollowSearch=followUpInfoService.getRecord("1-1",1,f_date);
        if(myFollowSearch!=null)System.out.println(myFollowSearch.getAns());
        else System.out.println("New code Wrong");
    }
}
