package com.example.myapp.service;

import com.example.myapp.pojo.speakInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface SpeakInfoService {
    public String getContent();
    public void setContent(String content);
}
