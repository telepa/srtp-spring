package com.example.myapp.service;

import com.example.myapp.pojo.user_info;

public interface UserInfoService {
    public user_info getInfo(int id);
    public void setNewUserInfo(int id);
    public void setName(int id,String name);
    public void setGender(int id,char gender);
    public void setBirth(int id,java.sql.Date birth);
    public void setTele(int id,String tele);
    public void setSurgeryOrNot(int id,char myBool);
    public void setSurgeryDate(int id,java.sql.Date SurgeryDate);
    public void setLanguage(int id,String Language);
}
