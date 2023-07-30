//package com.cj.NettyModule.Netty;
//
//@Slf4j
//public class MsgPackEncoder extends MessageToByteEncoder<NettyMsg> {
//
//
//    @Override
//    protected void encode(ChannelHandlerContext ctx, NettyMsg msg, ByteBuf out) {
//        log.info("MsgPackEncoder encode:{}", msg);
//        // 写入开头的标志
//        out.writeShort(msg.getMsgHead().getStartSign());
//        // 写入消息类型
//        out.writeByte(msg.getMsgHead().getMsgType());
//        // 写入秒时间戳
//        out.writeInt(msg.getMsgHead().getTimeStamp());
//        byte[] bytes = msg.getMsg().getBytes();
//        // 写入长度
//        out.writeShort((short)bytes.length);
//        // 写入消息主体
//        out.writeBytes(bytes);
//    }
//}