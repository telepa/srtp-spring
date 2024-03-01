package com.example.myapp.pojo;

import java.sql.Date;

public class follow_up_info {
    //f_id,id,classify,f_date,question,ans,score
    public String f_id;
    public int id;
    public String classify;
    public java.sql.Date f_date;
    public String question;
    public String ans;
    public int score;

    //interface
    public void setF_id(String f_id){this.f_id=f_id;}
    public String getF_id(){return f_id;}
    public void setId(int id){this.id=id;}

    public int getId() {
        return id;
    }

    public void setClassify(String classify){this.classify=classify;}

    public String getClassify() {
        return classify;
    }

    public void setF_date(java.sql.Date f_date){this.f_date=f_date;}

    public Date getF_date() {
        return f_date;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getAns() {
        return ans;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
