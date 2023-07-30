//package com.cj.NettyModule.Netty;
//
//public class NettyConstants {
//    public static final String ACCOUNT = "123456";
//    public static final String PASSWORD = "123456";
//    public static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap();
//
//    public static final String ACK_LOGIN_ALARM = "ackLoginAlarm;";
//
//    public static final String ACK_SYNC_ALARMMSG = "ackSyncAlarmMsg;";
//    public static final String ACK_HEART_BEAT = "ackHeartBeat;";
//    public static final String REQ_LOGIN_ALARM = "reqLoginAlarm;";
//    public static final String REQ_SYNC_ALARMMSG = "reqSyncAlarmMsg;";
//    public static final String REQ_HEART_BEAT = "reqHeartBeat;";
//
//
//    public static final String ACK_LOGIN_ALARM_RESULT_OK = StrUtil.concat(Boolean.TRUE,
//            ACK_LOGIN_ALARM, "result=succ;resDesc=null");
//
//    public static final String ACK_LOGIN_ALARM_RESULT_FAIL = StrUtil.concat(Boolean.TRUE,
//            ACK_LOGIN_ALARM, "result=fail;resDesc=username-or-key-error");
//    /**
//     * 正确的登录验证字符串
//     */
//    public static final String ALARM_LOGIN_REQ_SUCCESS = StrUtil.concat(
//            Boolean.TRUE,
//            REQ_LOGIN_ALARM,
//            "user=",
//            ACCOUNT,
//            ";key=",
//            PASSWORD,
//            ";type=msg"
//    );
//}