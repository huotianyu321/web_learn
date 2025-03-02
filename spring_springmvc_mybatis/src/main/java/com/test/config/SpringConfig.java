package com.test.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*spring的配置类，用于扫描不归springmvc管的bean*/
@Configuration

/*这种写法适合给不同的包这是不同的加载属性，比如过滤策略，是否懒加载*/
//@ComponentScans(value = {
//        @ComponentScan("com.test.service"),
//        @ComponentScan("com.test.dao")
//})

/*这种写法适合不同的包有相同的加载属性*/
/*DAO层使用的是MyBatis的代理，不需要Spring来管理实际的Bean,这里不扫描dao也可以*/
@ComponentScan({"com.test.service", "com.test.dao"})

/*指定外部属性文件*/
@PropertySource("classpath:jdbc.properties")

/*也可以在要导入的配置类上写@Configuration，通过被ComponentScan扫描加载*/
@Import({JdbcConfig.class, MyBatisConfig.class})

@EnableTransactionManagement
public class SpringConfig {
    // TODO
}
