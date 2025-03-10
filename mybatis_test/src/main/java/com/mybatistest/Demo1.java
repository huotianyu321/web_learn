package com.mybatistest;

import java.io.InputStream;
import java.util.List;
// 导入mybatis的Resource
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 使用配置文件执行sql
public class MybatisDemo {
    public static void main(String[] args) throws Exception {
        // 1.读取配置文件 创建工厂对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.使用工厂对象创建sqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        // 3.使用sqlSession对象执行sql语句

        List<Stu> stus = session.selectList("com.hty.mapper.StuMapper.selectAll");
        System.out.println(stus);

//        Stu stu= session.selectOne("stu.selectOne", 1);
//        System.out.println(stu);

//        Map<String, Object> params = new HashMap<>();
//        params.put("math", 90);
//        params.put("english", 90);
//        List<Stu> stus = session.selectList("stu.selectPart", params);
//        System.out.println(stus);

//        Map<String, Object> params = new HashMap<>();
//        params.put("id", 3);
//        params.put("math", 100);
//        params.put("english", 100);
//        int rowsAffected = session.update("stu.updateById", params);
//        session.commit();
//        System.out.println(rowsAffected);

        session.close();
    }
}
