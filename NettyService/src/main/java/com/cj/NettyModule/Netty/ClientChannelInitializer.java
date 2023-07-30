//package com.cj.NettyModule.Netty;
//
//public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
//    @Override
//    protected void initChannel(SocketChannel ch) throws Exception {
//        //设置超时时间
//        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast(new IdleStateHandler(30, 30, 60, TimeUnit.SECONDS));
//        //定长解码器
//        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024*100, 0, 2, 0, 2));
//
//        pipeline.addLast(new MsgPackDecoder());
//
//        //这里设置读取报文的包头长度来避免粘包
//        pipeline.addLast(new LengthFieldPrepender(2));
//
//        pipeline.addLast(new MsgPackEncoder());
//
//        //心跳续约
//        pipeline.addLast(new HeartBeatReqHandler());
//        //登录校验
//        pipeline.addLast(new LoginAuthReqHandler());
//        //消息处理
//        pipeline.addLast(new ChatReqHandler());
//    }
//}
