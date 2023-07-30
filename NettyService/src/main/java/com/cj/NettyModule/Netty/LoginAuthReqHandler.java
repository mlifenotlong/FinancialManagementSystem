package com.cj.NettyModule.Netty;

import com.cj.NettyModule.client.LoginUtil;
import com.cj.NettyModule.client.MessageType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.channels.Channel;

@Slf4j
public class LoginAuthReqHandler extends ChannelInboundHandlerAdapter {
    /**
     * 通道激活 发送登录请求信息
     *
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        NettyMsg nettyMsg = new NettyMsg(null,
                null,
                NettyConstants.ALARM_LOGIN_REQ_SUCCESS);
        nettyMsg.getMsgHead().setMsgType((byte) MessageType.REQLOGINALARM.getCode());

        log.info("LoginAuthReqHandler channelActive,发送登录信息：{}", nettyMsg);
        ctx.writeAndFlush(nettyMsg);

    }

    /**
     * channel读取数据
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("LoginAuthReqHandler channelRead 收到信息：{}", msg);

        String msgDate = msg.toString();
        if (msgDate.contains(MessageType.ACKLOGINALARM.getMsgType())) {
            if (msgDate.contains(NettyConstants.ACK_LOGIN_ALARM_RESULT_OK)) {
                //标记为已登录状态
                LoginUtil.markAsLogin((Channel) ctx.channel());
                log.info("登录成功");
                // 一行代码实现逻辑的删除 删除LoginAuthReqHandler
                ctx.pipeline().remove(this);
                // 将事件继续传播下去
                ctx.fireChannelActive();
            } else {
                log.info("登录失败");
                ctx.channel().close();
            }
        } else {
            // 将事件继续传播下去
            ctx.fireChannelActive();
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * channel (拦截器)移除 处理器方法执行完
     *
     * @return
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        if (LoginUtil.hasLogin((Channel) ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无需再次验证");
        } else {
            System.out.println("无登录验证，强制关闭连接!");
        }
    }


}
