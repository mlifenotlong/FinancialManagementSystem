package com.cj.NettyModule.client;

import com.cj.NettyModule.Netty.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvercmBusinessApp implements CommandLineRunner {
    @Value("${netty.socket.port}")
    private Integer port;
    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(EvercmBusinessApp.class, args);
    }

    @Override
    public void run(String... args) {
        this.nettyServer.start(this.port);
    }
}
