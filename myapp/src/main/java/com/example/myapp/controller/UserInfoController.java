package com.example.myapp.controller;

import com.example.myapp.pojo.user_info;
import com.example.myapp.service.FollowUpInfoService;
import com.example.myapp.service.UserInfoService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    FollowUpInfoService followUpInfoService;
    @RequestMapping("/getUserInfo")
    public user_info getUserInfo(int id){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
            userInfoService.setLanguage(id,"zh-cn");
        }
        return userInfoService.getInfo(id);
    }
    @RequestMapping("/setName")
    public void setName(int id,String name){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
            userInfoService.setLanguage(id,"zh-cn");
        }
        userInfoService.setName(id,name);
    }
    @RequestMapping("/setGender")
    public void setGender(int id,char gender){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
            userInfoService.setLanguage(id,"zh-cn");
        }
        userInfoService.setGender(id,gender);
    }
    @RequestMapping("/setBirth")
    public void setBirth(int id,java.sql.Date birth){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
            userInfoService.setLanguage(id,"zh-cn");
        }
        userInfoService.setBirth(id,birth);
    }
    @RequestMapping("/setTele")
    public void setTele(int id,String tele){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
            userInfoService.setLanguage(id,"zh-cn");
        }
        userInfoService.setTele(id,tele);
    }
    @RequestMapping("/setSurgeryOrNot")
    public void setSurgeryOrNot(int id,char myBool){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
            userInfoService.setLanguage(id,"zh-cn");
        }
        userInfoService.setSurgeryOrNot(id,myBool);
    }
    @RequestMapping("/setSurgeryDate")
    public void setSurgeryDate(int id,java.sql.Date SurgeryDate){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
            userInfoService.setLanguage(id,"zh-cn");
        }
        userInfoService.setSurgeryDate(id,SurgeryDate);
    }
    @RequestMapping("/setLanguage")
    public void setLanguage(int id,String Language){
        if(userInfoService.getInfo(id)==null){
            userInfoService.setNewUserInfo(id);
        }
        userInfoService.setLanguage(id,Language);
    }
    @RequestMapping("getLastDate")
    public java.sql.Date getLastDate(java.sql.Date today,int id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //设置能查询的最早日期
        Date d1 = (Date) sdf.parse("2023-09-01");
        //在范围内逐天进行查询
        int flag=0;
        while(d1.before(today)){
            today=getPreDoneScore(today);
            //统计当天答题条数
            int tmp=followUpInfoService.getLines(id,today);
            if(tmp==37){//若全部都答，则跳出循环返回该日期
                flag=1;
                break;
            }
        }
        if(flag==1)return today;
        else return null;
    }
    //Date是java.sql.Date类型
    //返回该日期的前一天日期
    protected java.sql.Date getPreDoneScore(Date holdDate) {
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(holdDate);
        calendar.add(calendar.DATE, -7);
        // calendar的time转成java.util.Date格式日期
        java.util.Date utilDate = (java.util.Date)calendar.getTime();
        calendar.add(calendar.DATE, 6);
        utilDate = (java.util.Date)calendar.getTime();
        //java.util.Date日期转换成转成java.sql.Date格式
        Date newDate =new Date(utilDate.getTime());
        return newDate;
    }
}
