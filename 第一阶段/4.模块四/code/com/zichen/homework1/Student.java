package com.zichen.homework1;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private static final long serialVersionUID = -3043976977950483198L;
    private int id;
    private String name;
    private int age;

    public Student(){}

    public Student(int id, String name, int age) throws IdException, AgeException {
        setId(id);
        setName(name);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws IdException {
        if(id <= 0){
            throw new IdException("ID小于等于0！");
        }else{
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if(age <= 0){
            throw new AgeException("年龄小于等于0！");
        }else{
            this.age = age;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", age=" + age ;
    }
}
