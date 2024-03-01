package com.example.myapp.pojo;
//table account
public class account {
    //id,user_name,pwd
    public int id;
    public String user_name;
    public String pwd;
    //id
    public int getId(){return id;}
    public void setId(int myid){this.id=myid;}
    //user_name
    public String getUser_name(){return user_name;}
    public void setUser_name(String a){this.user_name=a;}
    //pwd
    public String getPwd(){return pwd;}
    public void setPwd(String mypwd){this.pwd=mypwd;}
}
