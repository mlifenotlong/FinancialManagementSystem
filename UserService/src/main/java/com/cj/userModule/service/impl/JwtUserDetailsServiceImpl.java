package com.cj.userModule.service.impl;


import com.cj.userModule.Do.JwtUser;
import com.cj.userModule.mapper.SysUserMapper;
import com.cj.userModule.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author K. L. Mao
 * @create 2019/1/11
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo user = sysUserMapper.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }

//        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(Role::getRolename).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new JwtUser(user.getUsername(), user.getPassword(),null,null);
    }
}