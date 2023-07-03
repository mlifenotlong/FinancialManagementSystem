package com.cj.userModule.service.impl;

import com.cj.userModule.filter.entity.SysUser;
import com.cj.userModule.mapper.SysUserMapper;
import com.cj.userModule.service.SysUserService;
import com.cj.userModule.util.R;
import com.cj.userModule.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>  implements SysUserService {
@Autowired
SysUserMapper sysUserMapper;
/*@Autowired
    PasswordEncoder passwordEncoder;*/
    @Override
    public R regist(UserVo user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        sysUserMapper.insert(user);
        return R.ok();
    }

    @Override
    public ArrayList<UserVo> getUserLists() {

        System.out.println(sysUserMapper.getUserLists().get(0).getRoles());
        return sysUserMapper.getUserLists();
    }


    @Override
    public UserVo getUserByUsername(String username) {

        return sysUserMapper.getUserByUsername(username);
    }




}
