package com.zichen.web;

import com.zichen.dao.UserDaoImplementation;
import com.zichen.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        UserDaoImplementation userDao = new UserDaoImplementation();
        User user = userDao.searchUser(name);
        if(user == null || !user.getPassword().equals(password)){
            resp.sendRedirect(req.getContextPath()+"/login");
        }else{
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user",name);
            httpSession.setAttribute("isLogin", true);
            resp.sendRedirect(req.getContextPath()+"/main");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
