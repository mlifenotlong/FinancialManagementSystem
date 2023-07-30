package com.cj.prizeDrawModule.controller;


import com.cj.prizeDrawModule.service.PrizeDrawService;
import com.cj.prizeDrawModule.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prizeDraw")
public class PrizeDrawController {
    @Autowired
    PrizeDrawService prizeDrawService;
   @RequestMapping("start")
    public R start(){
        return prizeDrawService.start();
    }
}
