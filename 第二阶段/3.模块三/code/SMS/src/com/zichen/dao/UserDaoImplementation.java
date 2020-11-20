package com.zichen.dao;

import com.zichen.domain.User;
import com.zichen.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImplementation implements UserDaoInterface {

    @Override
    public User searchUser(String name) {
        Connection connection = JDBCUtil.getConnection();
        User res = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where name=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
               String password = resultSet.getString("password");
               res =  new User(name, password);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
            return res;
        }
    }
}
