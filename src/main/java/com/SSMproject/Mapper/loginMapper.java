package com.SSMproject.Mapper;


import com.SSMproject.entity.User;
import com.SSMproject.entity.loginRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface loginMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    public User login(loginRequest loginRequest);
}
