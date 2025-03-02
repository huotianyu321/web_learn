package com.test.service;

import com.test.config.SpringConfig;
import com.test.mapper.UserMapper;
import com.test.pojo.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSaveOne() {
        User user = new User();
        user.setUserName("6666");
        user.setPassword("7777777777777");
        System.out.println(userMapper.saveOne(user));
    }

}
