package com.cj.userModule.service.impl;

import com.cj.userModule.filter.entity.SysPermission;
import com.cj.userModule.mapper.SysPermissionMapper;
import com.cj.userModule.service.SysPermissionService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
@Autowired
SysPermissionMapper sysPermissionMapper;


}
