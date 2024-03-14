package com.example.retbot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.retbot.enity.User;
import com.example.retbot.util.R;

public interface UserService extends IService<User> {
    public R login(User user);

    R regrist(User user);
}
