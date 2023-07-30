//package com.cj.NettyModule.client;
//
//public class NettyConstants {
//
//    public static int LOCAL_PORT = 53535;
//    public static String LOCAL_IP = "127.0.0.1";
//
//    public static final String ACCOUNT="123456";
//
//    public static final String PASSWORD="123456";
//
//
//    /**
//     * 登录请求响应消息名
//     */
//    public static final String ACK_LOGIN_ALARM = "ackLoginAlarm;";
//
//    /**
//     * 登录响应-成功
//     */
//    public static final String ACK_LOGIN_ALARM_RESULT_OK = StrUtil.concat(
//            Boolean.TRUE,
//            ACK_LOGIN_ALARM,
//            "result=succ;resDesc=null"
//    );
//    /**
//     * 登录响应-失败
//     */
//    public static final String ACK_LOGIN_ALARM_RESULT_FAIL = StrUtil.concat(
//            Boolean.TRUE,
//            ACK_LOGIN_ALARM,
//            "result=fail;resDesc=username-or-key-error"
//    );
//
//
//    /**
//     * 心跳响应消息名
//     */
//    public static final String ACK_HEART_BEAT = "ackHeartBeat;";
//
//    /**
//     * 登录请求消息名
//     */
//    public static final String REQ_LOGIN_ALARM = "reqLoginAlarm;";
//
//
//
//    /**
//     * 心跳请求消息名
//     */
//    public static final String REQ_HEART_BEAT = "reqHeartBeat;";
//
//    /**
//     * 正确的登录验证字符串
//     */
//    public static final String ALARM_LOGIN_REQ_SUCCESS = StrUtil.concat(
//            Boolean.TRUE,
//            NettyConstants.REQ_LOGIN_ALARM,
//            "user=",
//            ACCOUNT,
//            ";key=",
//            PASSWORD,
//            ";type=msg"
//    );
//
//
//}