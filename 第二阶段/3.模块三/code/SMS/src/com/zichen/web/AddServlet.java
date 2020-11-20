package com.zichen.web;

import com.zichen.dao.StudentDaoImplementation;
import com.zichen.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        StudentDaoImplementation studentDaoImplementation = new StudentDaoImplementation();
        studentDaoImplementation.addStudent(new Student(name,gender,birthday));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
