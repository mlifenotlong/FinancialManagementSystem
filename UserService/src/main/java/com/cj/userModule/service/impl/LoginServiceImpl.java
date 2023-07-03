package com.cj.userModule.service.impl;

import com.cj.userModule.service.LoginService;
import com.cj.userModule.service.SysUserService;
import com.cj.userModule.util.JwtTokenUtil;

import com.cj.userModule.util.R;
import com.cj.userModule.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class LoginServiceImpl implements LoginService {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;
    private SysUserService sysUserService;

    @Autowired
    public LoginServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,SysUserService sysUserService
            ) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.sysUserService= sysUserService;
    }

    @Override
    public R login(UserVo userVo) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userVo.getUsername(), userVo.getPassword());
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userVo.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);


        return R.ok().data("token",token);
    }
    @Override
    public R register(UserVo userToAdd) {
        final String username = userToAdd.getUsername();
//        if(sysUserService.findByUsername(username)!=null) {
//            return null;
//        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
//        userToAdd.setLastPasswordResetDate(new Date());
//        userToAdd.setRoles(asList("ROLE_USER"));

        sysUserService.regist(userToAdd);
        return R.ok();
    }
//    @Override
//    public String refresh(String oldToken) {
//        final String token = oldToken.substring(tokenHead.length());
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
//            return jwtTokenUtil.refreshToken(token);
//        }
//        return null;
//    }
}
