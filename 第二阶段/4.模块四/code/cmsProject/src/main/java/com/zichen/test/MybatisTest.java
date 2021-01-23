package com.zichen.test;


import com.zichen.dao.EmployeeDao;
import com.zichen.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testMybatis() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        List<Employee> all = mapper.findAll();
        for (Employee employee : all){
            System.out.println(employee);
        }
        sqlSession.close();
    }
}
