package com.example.retbot.controller;

import com.example.retbot.enity.User;
import com.example.retbot.service.UserService;
import com.example.retbot.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("login")
    public R login(User user){

        return userService.login(user);
    }
    @RequestMapping("regist")
    public R regist(@RequestBody User user){
//        user.setUserId(2);
        user.setBalance(0);
        user.setStatus(1);
        user.setWalletStatus(1);
        return userService.regrist(user);
    }
}
