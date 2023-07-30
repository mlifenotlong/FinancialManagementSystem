//package com.cj.NettyModule.Netty;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//import lombok.extern.slf4j.Slf4j;
//
//import java.awt.*;
//import java.util.Scanner;
//
//@Slf4j
//public class ChatReqHandler extends ChannelInboundHandlerAdapter {
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) {
//        log.info("ChatReqHandler channelActive,IM系统准备就绪，请发送消息: ");
//        new Thread(() -> {
//            while (true) {
//                //读取用户在命令行输入的各种数据类型 Terminal控制台输入数据
//                Scanner sc = new Scanner(System.in);
//                //此扫描器执行当前行，并返回跳过的输入信息
//                String line = sc.nextLine();
//                log.info("控制台输入：{}", line);
//                NettyMsg nettyMsg = new NettyMsg(
//                        MessageType.REQSYNCALARMMSG.getCode(),
//                        NettyMsg.getCurrentTimeStamp(),
//                        line
//                );
//                nettyMsg.getMsgHead().setMsgType((byte) TrayIcon.MessageType.REQSYNCALARMMSG.getCode());
//
//                log.info("发送消息：{}", nettyMsg);
//                //发送数据并刷新
//                ctx.writeAndFlush(nettyMsg);
//            }
//        }).start();
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
////        NettyMsg nettyMsg = NettyMsg.nettyMsgParse(msg.toString());
//        log.info("ChatReqHandler channelRead 收到信息：{}", msg);
//    }
//
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
//        ctx.close();
//    }
//}