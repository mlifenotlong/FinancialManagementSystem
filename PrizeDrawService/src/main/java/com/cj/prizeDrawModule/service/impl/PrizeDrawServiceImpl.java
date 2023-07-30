package com.cj.prizeDrawModule.service.impl;

import com.cj.prizeDrawModule.Mapper.PrizeDrawMapper;
import com.cj.prizeDrawModule.service.PrizeDrawService;
import com.cj.prizeDrawModule.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class PrizeDrawServiceImpl implements PrizeDrawService {
    @Autowired
    PrizeDrawMapper prizeDrawMapper;
    //开始抽奖
    @Override
    public R start() {
        List list=prizeDrawMapper.listPrizeDraw();
        Random random=new Random();
        return R.ok().addData("随机的菜为",list.get(random.nextInt(list.size())));
    }
}
