package com.example.retbot.enity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

//import java.sql.Date;

import java.util.Date;
/**
 * 用户类
 */
@Data
public class User {
//  用户id
    @TableId(type = IdType.AUTO)
    int userId;
//  用户名称
    String username;
//  用户密码
    String password;
//  用户余额
    double balance;
//  用户状态
    int status;
//    钱包状态
    int walletStatus;
//    创建时间
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
//    更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date updateTime;
}
