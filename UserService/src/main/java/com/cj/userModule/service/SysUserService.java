package com.cj.userModule.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cj.userModule.filter.entity.SysUser;
import com.cj.userModule.util.R;
import com.cj.userModule.vo.UserVo;


import java.util.ArrayList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-11-04
 */
public interface SysUserService extends IService<SysUser> {
    R regist(UserVo user) ;

    ArrayList<UserVo> getUserLists();
    UserVo getUserByUsername(String username);


}
