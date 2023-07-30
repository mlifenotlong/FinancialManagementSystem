package com.cj.NettyModule.client;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageType {

    REALTIMEALARM("realTimeAlarm", 0),
    REQLOGINALARM("reqLoginAlarm", 1),
    ACKLOGINALARM("ackLoginAlarm", 2),
    REQSYNCALARMMSg("reqSyncAlarmMsg", 3),
    ACKSYNCALARMMSg("ackSyncAlarmMsg", 4),
    REQHEARTBEAT("reqHeartBeat", 8),
    ACKHEARTBEAT("ackHeartBeat", 9),
    CLOSECONNALARM("closeConnAlarm", 10);

    private String msgType;

    private int code;
}