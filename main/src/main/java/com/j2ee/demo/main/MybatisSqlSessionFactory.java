package com.j2ee.demo.main;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
/**
 * Created by rihai on 6/24/2017.
 */
public class MybatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            InputStream stream=   Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static  SqlSessionFactory getSqlSessionFactory(){
        return  sqlSessionFactory;
    }


}
