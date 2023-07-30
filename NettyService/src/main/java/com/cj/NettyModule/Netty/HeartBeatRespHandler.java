//package com.cj.NettyModule.Netty;
//
//@Slf4j
//@Sharable
//@Component
//public class HeartBeatRespHandler extends SimpleChannelInboundHandler {
//
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        log.info("HeartBeatRespHandler channelRead ：[{}]", msg);
//
//        String msgData = (String) msg;
//        if (NettyConstants.userIdChannelMap.size() > 0) {
//            //是否是心跳请求
//            if (msgData.contains(MessageType.REQHEARTBEAT.getMsgType())) {
//                log.info("收到客户端心跳请求,响应心跳请求..");
//                String ackMsg = msgData.replace(NettyConstants.REQ_HEART_BEAT, NettyConstants.ACK_HEART_BEAT);
//                NettyMsg nettyMsg = new NettyMsg(MessageType.ACKHEARTBEAT.getCode(),
//                        NettyMsg.getCurrentTimeStamp(),
//                        ackMsg);
//                nettyMsg.getMsgHead().setMsgType((byte) MessageType.ACKHEARTBEAT.getCode());
//
//                String ackHeartBeatMsg = NettyMsg.buildNettyMsg(nettyMsg);
//                log.info("响应心跳请求信息：[{}]", ackHeartBeatMsg);
//                ctx.writeAndFlush(nettyMsg);
//            } else {
//                ctx.fireChannelRead(msgData);
//            }
//        } else {
//            ctx.fireChannelRead(msgData);
//        }
//
//    }
//
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) {
//    }
//
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) {
//        NettyConstants.userIdChannelMap.clear();
//        log.info("服务端已关闭");
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
//        }
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
//        ctx.close();
//    }
//}
