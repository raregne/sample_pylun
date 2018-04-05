package com.pylun.member.dao;

import com.pylun.member.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO
{
    int insertUser(User user);
    User findByUsername(String username);
    User getUser(User user);

}
