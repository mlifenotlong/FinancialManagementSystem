//package com.cj.NettyModule.Netty;
//
//
//@Slf4j
//public class MsgPackDecoder extends ByteToMessageDecoder {
//    /**
//     * 协议开始标志
//     */
//    private short headData = (short) 0xFFFF;
//    private int headLength = 9;
//
//    @Override
//    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
//        log.info("MsgPackDecoder decode....");
//        // 保证魔法词和数组长度有效
//        if (in.readableBytes() < headLength) {
//            return;
//        }
//        in.markReaderIndex();
//        short startIndex = in.readShort();
//        log.info("startIndex:{}", startIndex);
//        if (startIndex != headData) {
//            in.resetReaderIndex();
//            throw new CorruptedFrameException("无效开始标志: " + startIndex);
//        }
//        byte msgType = in.readByte();
//        log.info("msgType:{}", msgType);
//        in.markReaderIndex();
//        int timeStamp = in.readInt();
//        log.info("timeStamp:{}", timeStamp);
//        in.markReaderIndex();
//
//        short lenOfBody = in.readShort();
//        log.info("lenOfBody:{}", lenOfBody);
//        if (in.readableBytes() < lenOfBody) {
//            in.resetReaderIndex();
//            return;
//        }
//        in.markReaderIndex();
//
//        // 消息的长度
//        byte[] msgByte = new byte[lenOfBody];
//        in.readBytes(msgByte);
//        String msgContent = new String(msgByte);
//        log.info("收到的字节码转成字符串：{}", msgContent);
//        out.add(msgContent);
//    }
//}