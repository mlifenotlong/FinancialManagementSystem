package com.example.rename.netty.client.config;


import com.example.rename.netty.common.dispatcher.MessageDispatcher;
import com.example.rename.netty.common.dispatcher.MessageHandlerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyClientConfig {

    @Bean
    public MessageDispatcher messageDispatcher() {
        return new MessageDispatcher();
    }

    @Bean
    public MessageHandlerContainer messageHandlerContainer() {
        return new MessageHandlerContainer();
    }

}
