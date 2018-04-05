package com.pylun.service.common.service;

import com.pylun.service.common.model.Account;
import com.pylun.member.model.User;
import com.pylun.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    @Autowired
    private UserService userService;

    public Account findByUsername(String username)
    {
        User user = userService.findByUsername(username);
        Account account = new Account(user);
        account.setRole("USER");

        return account;
    }

}
