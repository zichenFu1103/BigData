package com.zichen.dao;

import com.zichen.domain.Student;
import com.zichen.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDaoImplementation implements StudentDaoInterface{
    @Override
    public boolean addStudent(Student student) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into student (name, gender, birthday) values (?, ?, ?); ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setString(3, student.getBirthday());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement);
        }
        return true;
    }
}
