//package com.cj.NettyModule.Netty;
//
//@Slf4j
//public class HeartBeatReqHandler extends SimpleChannelInboundHandler {
//
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) {
//        //直接跳转到下个handler请求
//        log.info("HeartBeatReqHandler channelActive...");
//        ctx.fireChannelActive();
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        log.info("HeartBeatReqHandler channelRead 收到信息：{}", msg);
//
//        String msgData = (String) msg;
//        log.info("收到的字节码转成字符串：{}", msgData);
//
//        if (LoginUtil.hasLogin(ctx.channel())) {
//            //判断是否是心跳请求
//            if (msgData.contains(MessageType.ACKHEARTBEAT.getMsgType())) {
//                log.info("收到心跳响应:{}", msgData);
//            }else{
//                //没有登录 直接跳转到下个handler请求
//                ctx.fireChannelRead(msgData);
//            }
//        } else {
//            //没有登录 直接跳转到下个handler请求
//            ctx.fireChannelRead(msgData);
//        }
//
//    }
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) {
//
//    }
//
//
//    /**
//     * 退出登录
//     */
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) {
//        UserChannelUtil.unBindUser(ctx.channel());
//        LoginUtil.logoOut(ctx.channel());
//        System.out.println("客户端已关闭");
//    }
//
//    @Override
//    public void userEventTriggered(ChannelHandlerContext ctx, Object obj) {
//        if (obj instanceof IdleStateEvent) {
//            IdleStateEvent event = (IdleStateEvent) obj;
//            if (event.state() == IdleState.READER_IDLE) {
//                log.info("客户端读超时");
//            } else if (event.state() == IdleState.WRITER_IDLE) {
//                log.info("客户端写超时");
//            } else if (event.state() == IdleState.ALL_IDLE) {
//                log.info("客户端所有操作超时");
//            }
//
//            NettyMsg nettyMsg = new NettyMsg(null,
//                    null, getHeartBeatReqMsg());
//            nettyMsg.getMsgHead().setMsgType((byte) MessageType.REQHEARTBEAT.getCode());
//
//            log.info("发送心跳请求:{}", nettyMsg);
//            ctx.writeAndFlush(nettyMsg);
//        }
//
//    }
//
//    /**
//     * 构建心跳请求信息
//     * @return
//     */
//    private String getHeartBeatReqMsg() {
//        int reqId = AlarmNettyClient.REQID.incrementAndGet();
//        String reqHeartBeatMsg = StrUtil.concat(
//                Boolean.TRUE, NettyConstants.REQ_HEART_BEAT,
//                "reqId=", reqId + "");
//        return reqHeartBeatMsg;
//    }
//}