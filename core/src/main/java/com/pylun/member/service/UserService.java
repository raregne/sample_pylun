package com.pylun.member.service;

import com.pylun.brand.service.BrandService;
import com.pylun.member.dao.UserDAO;
import com.pylun.member.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService
{
    static final Logger logger = LoggerFactory.getLogger(BrandService.class);

    @Autowired
    UserDAO userDAO;

    @Transactional(readOnly = true)
    public User findByUsername(String username)
    {
        return userDAO.findByUsername(username);
    }

    @Transactional
    public int insertUser(User user)
    {
        return userDAO.insertUser(user);
    }
}
