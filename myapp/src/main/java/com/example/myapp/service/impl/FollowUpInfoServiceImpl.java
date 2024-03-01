package com.example.myapp.service.impl;
import com.example.myapp.DAO.FollowUpInfoMapper;
import com.example.myapp.pojo.follow_up_info;
import com.example.myapp.service.FollowUpInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
@Service
@Component
public class FollowUpInfoServiceImpl implements FollowUpInfoService{
    @Autowired
    private FollowUpInfoMapper followUpInfoMapper;
    @Override
    public follow_up_info getRecord(@Param("f_id")String f_id, @Param("id")int id, @Param("f_date")java.sql.Date f_date){
        return followUpInfoMapper.getFollowInfo(f_id,id,f_date);
    }
    public void InsertRecord(@Param("f_id")String f_id,@Param("id")int id,@Param("classify")String classify,@Param("f_date")java.sql.Date f_date,@Param("question")String question,@Param("ans")String ans,@Param("score")int score){
        followUpInfoMapper.InsertAnswer(f_id,id,classify,f_date,question,ans,score);
    }
    public void DeleteRecords(@Param("id")int id,@Param("f_date")java.sql.Date f_date){
        followUpInfoMapper.Restart(id,f_date);
    }
    public int getLines(int id,java.sql.Date f_date){
        return followUpInfoMapper.getLines(id,f_date);
    }
}
