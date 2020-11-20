package com.zichen.domain;

import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 5311938255815422104L;

    private String name;
    private String gender;
    private String birthday;

    public Student(){}

    public Student( String name, String gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }
}
