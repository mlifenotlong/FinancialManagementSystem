package com.cj.userModule.vo;

import com.cj.userModule.filter.entity.SysUser;

import lombok.Data;

@Data
public class UserVo extends SysUser
{
    String roles;
}
