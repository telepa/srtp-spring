package com.example.myapp.service.impl;

import com.example.myapp.DAO.speakInfoMapper;
import com.example.myapp.pojo.speakInfo;
import com.example.myapp.service.AccountService;
import com.example.myapp.service.SpeakInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
@Component
public class SpeakInfoImpl implements SpeakInfoService {
    @Autowired
    private speakInfoMapper myspeakInfoMapper;
    @Override
    public String getContent(){
        return myspeakInfoMapper.getContent();
    }
    public void setContent(String content){
        myspeakInfoMapper.setContent(content);
    }
}
