//package com.cj.NettyModule.Netty;
//
//@Slf4j
//@Sharable
//@Component
//public class LoginAuthRespHandler extends ChannelInboundHandlerAdapter {
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        log.info("LoginAuthRespHandler channelRead ：[{}]", msg);
//        String msgData = (String) msg;
//
//        //判断是否登录
//        if (NettyConstants.userIdChannelMap.size() == 0) {
//            //判断是否是登录请求
//            if (msg.toString().contains(MessageType.REQLOGINALARM.getMsgType())) {
//                String ackLoginAlarmMsg;
//                if (msgData.contains(NettyConstants.ALARM_LOGIN_REQ_SUCCESS)) {
//                    NettyConstants.userIdChannelMap.put(msgData, ctx.channel());
//                    ackLoginAlarmMsg = NettyConstants.ACK_LOGIN_ALARM_RESULT_OK;
//                } else {
//                    ackLoginAlarmMsg = NettyConstants.ACK_LOGIN_ALARM_RESULT_FAIL;
//                }
//                NettyMsg nettyMsg = new NettyMsg(MessageType.ACKLOGINALARM.getCode(),
//                        NettyMsg.getCurrentTimeStamp(),
//                        ackLoginAlarmMsg);
//                nettyMsg.getMsgHead().setMsgType((byte) MessageType.ACKLOGINALARM.getCode());
//
//                log.info("登陆响应信息：[{}]", nettyMsg);
//                ctx.writeAndFlush(nettyMsg);
//            } else {
//                log.info("用户未登录发送的请求:[{}]，不予处理..", msgData);
//            }
//        } else {
//            log.info("用户已登录,收到信息Msg:[{}]", msgData);
//            ctx.fireChannelRead(msgData);
//        }
//    }
//
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
//        ctx.close();
//    }
//}