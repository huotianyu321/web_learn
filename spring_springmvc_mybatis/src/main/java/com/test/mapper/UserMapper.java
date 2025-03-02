package com.test.mapper;

import com.test.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> findList();

    @Select("select * from user where id = #{id}")
    public User findById(int id);

    @Insert("insert into user (user_name, password) values (#{userName}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id") // 设置主键返回
//    public User saveOne(User user); // 这个返回值不行
//    public int saveOne(User user); // 这个返回值可以
    public boolean saveOne(User user); // 这个返回值也可以


    @Delete("delete from user where id = #{id}")
    public int  deleteById(int id);

    @Update("update user set user_name = #{userName}, password = #{password} where id = #{id}")
    public int updateOne(User user);

}
