//package com.cj.NettyModule.Netty;
//
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
//import io.netty.handler.codec.LengthFieldPrepender;
//import io.netty.handler.timeout.IdleStateHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.nio.channels.SocketChannel;
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
//    @Autowired
//    private ChatRespHandler chatRespHandler;
//    @Autowired
//    private HeartBeatRespHandler heartBeatRespHandler;
//    @Autowired
//    private LoginAuthRespHandler loginAuthRespHandler;
//
//    @Override
//    protected void initChannel(SocketChannel socketChannel) {
//        ChannelPipeline pipeline = socketChannel.pipeline();
//        //用户每次请求都会从第一个Handler开始
//        //设置超时时间
//        pipeline.addLast(new IdleStateHandler(30, 30, 60, TimeUnit.SECONDS));
////        //定长解码器
//        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024*100, 0, 2, 0, 2));
//
//        //增加解码器
//        pipeline.addLast(new MsgPackDecoder());
//
////        //这里设置读取报文的包头长度来避免粘包
//        pipeline.addLast(new LengthFieldPrepender(2));
//
//        //增加编码器
//        pipeline.addLast(new MsgPackEncoder());
//
//        //心跳续约
//        pipeline.addLast(this.heartBeatRespHandler);
//        pipeline.addLast(this.loginAuthRespHandler);
//        pipeline.addLast(this.chatRespHandler);
//    }
//
//}
