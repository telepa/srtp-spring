package com.example.myapp.pojo;

import java.sql.Date;

public class user_info {
    //id,name,gender,birth,tele,surgery_or_not,surgery_date
    public int id;
    public String name;
    public char gender;
    public java.sql.Date birth;
    public String tele;
    public char surgery_or_not;
    public java.sql.Date surgery_date;
    public String Language;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public char getGender() {
        return gender;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public Date getBirth() {
        return birth;
    }
    public void setTele(String tele) {
        this.tele = tele;
    }
    public String getTele() {
        return tele;
    }
    public void setSurgery_or_not(char surgery_or_not) {
        this.surgery_or_not = surgery_or_not;
    }
    public char getSurgery_or_not() {
        return surgery_or_not;
    }
    public void setSurgery_date(Date surgery_date) {
        this.surgery_date = surgery_date;
    }
    public Date getSurgery_date() {
        return surgery_date;
    }
    public void setLanguage(String language) {
        Language = language;
    }
    public String getLanguage() {
        return Language;
    }
}
