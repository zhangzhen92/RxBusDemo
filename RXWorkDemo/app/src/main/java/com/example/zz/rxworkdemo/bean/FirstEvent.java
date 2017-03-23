package com.example.zz.rxworkdemo.bean;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2017/3/23 16:26
 */


public class FirstEvent {
    private String userName;
    private String age;

    public FirstEvent(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
