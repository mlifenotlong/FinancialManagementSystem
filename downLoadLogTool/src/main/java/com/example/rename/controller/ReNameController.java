package com.example.rename.controller;

import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.rename.entity.FormMessage;
import com.example.rename.tool.PoolTest;
import com.example.rename.tool.WebCrawlerDemo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
@CrossOrigin
@RestController

public class ReNameController {
    @RequestMapping("downloadLink")
    public  String renameLog(String serverName, Date startDay,Date endDay){
        System.out.println("hello");
        return null;
    }
    @RequestMapping("getDownLoadProcess")
    public String getDownloadProcess(HttpServletRequest request){
       Integer month= (Integer) request.getSession().getAttribute("month");
        Integer day= (Integer) request.getSession().getAttribute("day");
        return "now download for "+month+" month"+day+" day log";
    }
    @RequestMapping("test")
    public  String test(@RequestBody  String form, HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(-1);
        session.setAttribute("month",0);
        session.setAttribute("day",0);
        JSONObject jsonObject1 = JSONObject.parseObject(form);
        String ServiceName= (String) jsonObject1.get("downloadServer");
        WebCrawlerDemo webCrawlerDemo = new WebCrawlerDemo();
        String fileName=ServiceName+".txt";
        File file=new File(fileName);

        if(!file.exists()){
            webCrawlerDemo.myPrint("http://logtool.int.refinitiv.com/"+ServiceName+"/ThomsonReuters/CIBORG/Engine/Logs/?C=M;O=D",fileName);
        }
        System.out.println(form);
        PoolTest.run(form,session,fileName,ServiceName);
        if((Integer) (session.getAttribute("month"))==0){
            return "start to download";
        }
        else {
            return "please wait for download log";
        }

    }
}
