package com.cj.userModule.service;

import com.cj.userModule.filter.entity.SysRole;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
public interface SysRoleService extends IService<SysRole> {

    List<SysRole> getRoles(int userId) ;
}
