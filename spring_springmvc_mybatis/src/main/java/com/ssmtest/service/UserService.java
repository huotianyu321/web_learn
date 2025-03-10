package com.ssmtest.service;

import com.ssmtest.pojo.User;

import java.util.List;

public interface UserService {
    boolean saveOne(User use);

    List<User> findList();

    User findById(int id);

    boolean deleteById(int id);

    boolean updateOne(User user);

}
