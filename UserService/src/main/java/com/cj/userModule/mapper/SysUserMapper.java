package com.cj.userModule.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.userModule.filter.entity.SysUser;
import com.cj.userModule.vo.UserVo;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("SELECT u.id,u.usercode,u.username,u.password,u.salt,u.locked,role.name FROM test.sys_user as u join test.sys_user_role as r on u.id=r.sys_user_id \n" +
            "left join test.sys_role as role on r.sys_role_id=role.id  ")
    ArrayList<UserVo> getUserLists();
    @Select("SELECT u.id,u.usercode,u.username,u.password,u.salt,u.locked,role.name FROM test.sys_user as u left join test.sys_user_role as r on u.id=r.sys_user_id\n" +
            "   left join test.sys_role as role on r.sys_role_id=role.id where u.username=#{username} ")
    UserVo getUserByUsername(String username);
}
