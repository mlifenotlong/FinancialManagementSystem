package com.cj.userModule.mapper;

import com.cj.userModule.filter.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    @Select("select r.id,r.name,r.available from test.sys_user u left join test.sys_user_role \n" +
            "as ur on #{userId}=ur.sys_user_id left join test.sys_role as r on r.id=ur.sys_role_id ")
    List<SysRole> getRoles(int userId);
}
