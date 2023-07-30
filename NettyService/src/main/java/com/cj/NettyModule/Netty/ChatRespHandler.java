//package com.cj.NettyModule.Netty;
//
//@Slf4j
//@Sharable
//@Component
//public class ChatRespHandler extends ChannelInboundHandlerAdapter {
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        log.info("ChatRespHandler channelRead 接收聊天信息：[{}]", msg);
//        ctx.writeAndFlush(msg);
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
//        ctx.close();
//    }
//}
