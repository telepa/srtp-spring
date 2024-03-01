package com.example.myapp.DAO;

import com.example.myapp.pojo.follow_up_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.apache.ibatis.annotations.Param;
@Component
public interface FollowUpInfoMapper {
    follow_up_info getFollowInfo(@Param("f_id")String f_id,@Param("id")int id,@Param("f_date")java.sql.Date f_date);
    void InsertAnswer(@Param("f_id")String f_id,@Param("id")int id,@Param("classify")String classify,@Param("f_date")java.sql.Date f_date,@Param("question")String question,@Param("ans")String ans,@Param("score")int score);
    void Restart(@Param("id")int id,@Param("f_date")java.sql.Date f_date);
    int getLines(int id,java.sql.Date f_date);
}
