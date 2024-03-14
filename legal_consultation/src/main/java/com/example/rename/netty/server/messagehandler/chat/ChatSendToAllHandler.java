package com.example.rename.netty.server.messagehandler.chat;


import com.example.rename.netty.common.codec.Invocation;
import com.example.rename.netty.common.dispatcher.MessageHandler;
import com.example.rename.netty.server.message.chat.ChatRedirectToUserRequest;
import com.example.rename.netty.server.message.chat.ChatSendResponse;
import com.example.rename.netty.server.message.chat.ChatSendToAllRequest;

import com.example.rename.netty.server.server.NettyChannelManager;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatSendToAllHandler implements MessageHandler<ChatSendToAllRequest> {

    @Autowired
    private NettyChannelManager nettyChannelManager;

    @Override
    public void execute(Channel channel, ChatSendToAllRequest message) {
        // 这里，假装直接成功
        ChatSendResponse sendResponse = new ChatSendResponse().setMsgId(message.getMsgId()).setCode(0);
        channel.writeAndFlush(new Invocation(ChatSendResponse.TYPE, sendResponse));

        // 创建转发的消息，并广播发送
        ChatRedirectToUserRequest sendToUserRequest = new ChatRedirectToUserRequest().setMsgId(message.getMsgId())
                .setContent(message.getContent());
        nettyChannelManager.sendAll(new Invocation(ChatRedirectToUserRequest.TYPE, sendToUserRequest));
    }

    @Override
    public String getType() {
        return ChatSendToAllRequest.TYPE;
    }

}
