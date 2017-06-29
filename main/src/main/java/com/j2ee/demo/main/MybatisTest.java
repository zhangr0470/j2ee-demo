package com.j2ee.demo.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by rihai on 6/24/2017.
 */
public class MybatisTest {

    public static void main(String[] ags) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:SSS");
        Date now = new Date();
        String formatStr =formatter.format(now);
        System.out.print(formatStr);
        //selectTest();
        //addTest();
        //updateTest();
    }

    private static void addTest() {
        SqlSession session = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
        try {

            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setUserName("hellonew2");
            user.setCreateDate(new Date());
            mapper.addUser(user);
            System.out.print(String.format("new userid :%s",user.getId()));
            session.commit();

        } finally {
            session.close();
        }
    }

    private static void updateTest() {
        SqlSession session = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
        try {

            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setId(5);
            user.setUserName("fuck");
            user.setCreateDate(new Date());
            mapper.updateUser(user);
            session.commit();

        } finally {
            session.close();
        }
    }


    public static void selectTest(){
        SqlSession session = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
        try {
            //old
            User user =  session.selectOne("com.j2ee.demo.main.UserMapper.selectUserByID", 1);
            //new
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user2 = mapper.selectUserByID(2);

            //old
            List<User> list= session.selectList("com.j2ee.demo.main.UserMapper.getUsers");
            //new
            List<User> list2=mapper.getUsers();

            System.out.print("hello");
        } finally {
            session.close();
        }

    }
}
