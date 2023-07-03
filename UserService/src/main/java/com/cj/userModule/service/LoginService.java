package com.cj.userModule.service;
import com.cj.userModule.util.R;
import com.cj.userModule.vo.UserVo;


public interface LoginService {

    R login(UserVo userVo);

    R register(UserVo userToAdd);
}
