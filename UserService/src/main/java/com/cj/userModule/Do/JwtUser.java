package com.cj.userModule.Do;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author K. L. Mao
 * @create 2019/1/10
 */
public class JwtUser implements UserDetails {

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(String username, String password, Integer state, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
//        this.state = state;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未被锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}