package com.example.myapp.service.impl;


import com.example.myapp.DAO.UserInfoMapper;
import com.example.myapp.pojo.user_info;
import com.example.myapp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
@Component
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public user_info getInfo(int id){
        return userInfoMapper.getUserInfo(id);
    }
    public void setNewUserInfo(int id){
        userInfoMapper.setNewUser(id);
    }
    public void setName(int id,String name){
        userInfoMapper.setName(id,name);
    }
    public void setGender(int id,char gender){
        userInfoMapper.setGender(id,gender);
    }
    public void setBirth(int id,java.sql.Date birth){
        userInfoMapper.setBirth(id,birth);
    }
    public void setTele(int id,String tele){
        userInfoMapper.setTele(id,tele);
    }
    public void setSurgeryOrNot(int id,char myBool){
        userInfoMapper.setSurgeryOrNot(id,myBool);
    }
    public void setSurgeryDate(int id,java.sql.Date SurgeryDate){
        userInfoMapper.setSurgeryDate(id,SurgeryDate);
    }
    public void setLanguage(int id,String Language){userInfoMapper.setLanguage(id,Language);}
}
