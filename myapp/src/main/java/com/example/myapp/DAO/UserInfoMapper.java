package com.example.myapp.DAO;

import com.example.myapp.pojo.user_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;
import java.sql.Date;
@Component
public interface UserInfoMapper {
    user_info getUserInfo(int id);
    void setNewUser(int id);
    void setName(int id,String name);
    void setGender(int id,char gender);
    void setBirth(int id,java.sql.Date birth);
    void setTele(int id,String tele);
    void setSurgeryOrNot(int id,char myBool);
    void setSurgeryDate(int id,java.sql.Date SurgeryDate);
    void setLanguage(int id,String Language);
}
