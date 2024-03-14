package com.example.retbot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.retbot.enity.User;
import com.example.retbot.mapper.UserMapper;
import com.example.retbot.service.UserService;
import com.example.retbot.util.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public R login(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        //查询到的用户
        User findUser=new User();
        findUser=userMapper.selectOne(queryWrapper);
        if(findUser==null){
            return R.error().message("无法找到该用户");
        }

        if( findUser.getPassword()==  user.getPassword()){
            return R.ok().message("登录成功").data("user",user);
        }
        return R.error().message("账户或者绵密不正确");
    }

    @Override
    public R regrist(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        if(userMapper.exists(queryWrapper)){
            return R.error().message("用户已经存在");
        }
        userMapper.insert(user);
        return R.ok().message("注册成功");
    }
}
