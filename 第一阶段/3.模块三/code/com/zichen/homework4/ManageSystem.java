package com.zichen.homework4;

import java.util.ArrayList;
import java.util.List;

public class ManageSystem {

    List<Student> studentList = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (studentList.contains(student)) {
            return false;
        } else {
            studentList.add(student);
            return true;
        }
    }

    public boolean removeStudent(Student student) {
        if (studentList.contains(student)) {
            studentList.remove(student);
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyStudent(int id, String newName, int newAge){
        Student student = findStudentById(id);
        if(student != null){
            student.setName(newName);
            student.setAge(newAge);
            return true;
        }else {
            return false;
        }
    }

    public Student findStudentById(int id){
        for(Student student : studentList){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public List<Student> findStudentByName(String name){
        List<Student> res = new ArrayList<>();
        for(Student student : studentList){
            if(student.getName().equals(name)){
                res.add(student);
            }
        }
        if(res.size() > 0){
            return res;
        }else{
            return null;
        }
    }

    public void showAllStudents(){
        if(studentList.isEmpty()){
            System.out.println("学生档案为空，请添加学生信息！");
        }
       for(Student student : studentList){
           System.out.println(student.toString());
       }
    }
}
