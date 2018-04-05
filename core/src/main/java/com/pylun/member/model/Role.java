package com.pylun.member.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Role
{
    private long roIdx;
    private String roName;
    private Set<User> users;
}
