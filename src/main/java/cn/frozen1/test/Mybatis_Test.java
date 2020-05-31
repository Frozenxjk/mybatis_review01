package cn.frozen1.test;

import cn.frozen1.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Mybatis_Test {
    public static void main(String[] args) throws IOException {
        //指定全局配置文件
        String resource = "mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建sqlSession对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取Sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //操作CRUD
        User user = sqlSession.selectOne("MyMapper.selectUser",1);
        System.out.println(user);

    }
}
