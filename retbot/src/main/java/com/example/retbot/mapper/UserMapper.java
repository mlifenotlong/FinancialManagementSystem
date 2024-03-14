package com.example.retbot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.retbot.enity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
