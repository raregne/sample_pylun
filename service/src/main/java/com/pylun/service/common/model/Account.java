package com.pylun.service.common.model;

import com.pylun.member.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account extends User
{
    public Account(User user)
    {
        this.setUIdx(user.getUIdx());
        this.setComIdx(user.getComIdx());
        this.setUId(user.getUId());
        this.setUName(user.getUName());
        this.setUPassword(user.getUPassword());
        this.setUType(user.getUType());
    }
    String role;
}
