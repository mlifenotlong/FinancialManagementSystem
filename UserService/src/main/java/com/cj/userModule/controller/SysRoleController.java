package com.cj.userModule.controller;


import com.cj.userModule.filter.entity.SysRole;
import com.cj.userModule.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
@CrossOrigin
@RestController
@RequestMapping("/role")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;
    @RequestMapping("getRoles")
    public List<SysRole> GetRoles(int userId){
        return  sysRoleService.getRoles(userId);
    }
}

