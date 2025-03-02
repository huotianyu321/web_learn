package com.test.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig {
    /*创建SqlSessionFactory 注意需要标记为bean*/
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // mybatis需要数据源来连接数据库
        sqlSessionFactoryBean.setDataSource(dataSource);
        //mybatis为包下的类创建别名
        //这样在xml配置中的resultType不用写完整的类限定名，只需要写类名
        //在注解开发时的一些情况下也不需要写全类的限定名，比如：???
        sqlSessionFactoryBean.setTypeAliasesPackage("com.test.pojo");

        // 创建 MyBatis 的全局配置对象
        Configuration configuration = new Configuration();
        /*开启驼峰命名转换*/
        configuration.setMapUnderscoreToCamelCase(true);
        // 将全局配置设置到 SqlSessionFactoryBean 中
        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean;
    }

    /*注意需要标记为bean*/
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        /*
        * 自动扫描 com.test.mapper 包下的 Mapper 接口，并将它们注册为 MyBatis 的 Mapper Bean。
        * 通过 MapperScannerConfigurer，Spring 会自动将这些接口实现为 MyBatis 的代理对象, 并将其注册为 Spring 的 Bean
        */
        mapperScannerConfigurer.setBasePackage("com.test.mapper");
        return mapperScannerConfigurer;
    }
}
