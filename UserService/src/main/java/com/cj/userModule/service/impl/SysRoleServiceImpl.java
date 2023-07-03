package com.cj.userModule.service.impl;


import com.cj.userModule.filter.entity.SysRole;
import com.cj.userModule.mapper.SysRoleMapper;
import com.cj.userModule.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Override
    public List<SysRole> getRoles(int userId) {
        return sysRoleMapper.getRoles(userId);
    }
}
