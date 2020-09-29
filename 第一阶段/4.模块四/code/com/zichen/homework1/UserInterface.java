package com.zichen.homework1;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args){
        List<Student> studentList = null;
        String path = "./src/com/zichen/homework1/studentList.txt";
        File txt = new File(path);
        if (txt.exists()) {
            studentList = ReadList.readList(path);
        }else{
            studentList = new LinkedList<>();
        }
        try {
            workflow(studentList, path);
        } catch (AgeException | IdException e) {
            e.printStackTrace();
        }
    }

    public static void workflow(List<Student> studentList, String path) throws AgeException, IdException {
        System.out.println("---------------------------");
        System.out.println("       学生信息管理系统       ");
        System.out.println("---------------------------");
        ManageSystem ms = new ManageSystem(studentList);
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("1-增加学生信息");
            System.out.println("2-删除学生信息");
            System.out.println("3-修改学生信息");
            System.out.println("4-查找学生信息");
            System.out.println("5-打印所有学生信息");
            System.out.println("0-退出程序");
            System.out.println("请管理员输入操作代号0-5：");
            int order = sc.nextInt();
            switch (order){
                case 1:
                    System.out.println("请分别输入学生的学号，姓名和年龄：");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int age = sc.nextInt();
                    if(ms.addStudent(new Student(id, name, age))){
                        System.out.println("学生添加成功！");
                    }else{
                        System.out.println("学生添加失败！学号不能重复，请重新添加！");
                    }
                    break;
                case 2:
                    System.out.println("请输入想要删除学生的学号：");
                    int removeId = sc.nextInt();
                    Student student = ms.findStudentById(removeId);
                    if(student != null){
                        ms.removeStudent(student);
                        System.out.println("学生删除成功！");
                    }else{
                        System.out.println("学生删除失败！学号不存在，请重新查看！");
                    }
                    break;
                case 3:
                    System.out.println("请输入想要修改学生的学号：");
                    int modifyId = sc.nextInt();
                    if(ms.findStudentById(modifyId) == null){
                        System.out.println("学生修改失败，请检查学号！");
                    }else{
                        System.out.println("修改后的名字：");
                        String modifyName = sc.next();
                        System.out.println("修改后的年龄：");
                        int modifyAge = sc.nextInt();
                        ms.modifyStudent(modifyId,modifyName,modifyAge);
                        System.out.println("学生修改成功！");
                    }
                    break;
                case 4:
                    System.out.println("请输入想要查看学生的学号：");
                    int findId = sc.nextInt();
                    Student findStudent = ms.findStudentById(findId);
                    if(findStudent != null){
                        System.out.println(findStudent.toString());
                    }else{
                        System.out.println("该学号不存在，请重新查看！");
                    }
                    break;
                case 5:
                    ms.showAllStudents();
                    break;
                case 0:
                    flag = false;
                    System.out.println("程序已退出！");
                    WriteList.writeList(ms.returnStudentList(), path);
                    break;
            }
            System.out.println("---------------------------");
        }
    }
}
