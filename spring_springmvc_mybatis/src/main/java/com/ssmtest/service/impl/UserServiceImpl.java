package com.ssmtest.service.impl;

import com.ssmtest.controller.common.AppException;
import com.ssmtest.controller.common.ResultEnum;
import com.ssmtest.mapper.UserMapper;
import com.ssmtest.pojo.User;
import com.ssmtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean saveOne(User user) {
        return userMapper.saveOne(user);
    }

    @Override
    public List<User> findList() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new AppException(ResultEnum.FAIL.getCode(), e.getMessage());
        }
        return userMapper.findList();
    }

    @Override
    public User findById(int id) {
        if (id < 0) {
            throw new AppException(ResultEnum.FAIL.getCode(), "id不能小于0");
        }
        return userMapper.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        int res = userMapper.deleteById(id);
        return res > 0;
    }

    @Override
    public boolean updateOne(User user) {
        int res = userMapper.updateOne(user);
        return res > 0;
    }
}
