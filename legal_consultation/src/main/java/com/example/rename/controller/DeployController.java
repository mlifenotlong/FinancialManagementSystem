package com.example.rename.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeployController {
@RequestMapping("deploypage")
//https://github.com/yudaocode/SpringBoot-Labs/blob/master/lab-67/lab-67-netty-demo/lab-67-netty-demo-server/src/main/java/cn/iocoder/springboot/lab67/nettyserverdemo/config/NettyServerConfig.java
    public String DeployPage(){
        return "/vas/deploy.html";
}
}
