package com.example.myapp.DAO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface speakInfoMapper {
    String getContent();
    void setContent(String content);
}
