package com.example.rename.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeployController {
@RequestMapping("deploypage")
    public String DeployPage(){
        return "/vas/deploy.html";
}
}
