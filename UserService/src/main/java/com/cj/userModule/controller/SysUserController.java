package com.cj.userModule.controller;

import com.cj.userModule.service.SysUserService;
import com.cj.userModule.util.R;
import com.cj.userModule.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping
@CrossOrigin
public class SysUserController {
    @Autowired
    SysUserService sysUserService;
//    @Autowired
//    PasswordEncoder passwordEncoder;
    @GetMapping("getUserList")
    public R getUserList()
    {
        ArrayList<UserVo> userList=sysUserService.getUserLists();
        if(userList!=null){

            return R.ok().data("UserList",userList);
        }
        else return R.error();
    }
    @PostMapping("regist")
    public R Regist(UserVo user){

        return sysUserService.regist(user);
    }
}
