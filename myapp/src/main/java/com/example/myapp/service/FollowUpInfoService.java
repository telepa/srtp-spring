package com.example.myapp.service;

import com.example.myapp.pojo.follow_up_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface FollowUpInfoService {
    public follow_up_info getRecord(@Param("f_id")String f_id, @Param("id")int id, @Param("f_date")java.sql.Date f_date);
    public void InsertRecord(@Param("f_id")String f_id,@Param("id")int id,@Param("classify")String classify,@Param("f_date")java.sql.Date f_date,@Param("question")String question,@Param("ans")String ans,@Param("score")int score);
    public void DeleteRecords(@Param("id")int id,@Param("f_date")java.sql.Date f_date);
    public int getLines(int id,java.sql.Date f_date);
}
