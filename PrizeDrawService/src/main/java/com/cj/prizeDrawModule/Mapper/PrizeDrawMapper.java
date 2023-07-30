package com.cj.prizeDrawModule.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;



@Mapper
public interface PrizeDrawMapper {
    @Select("select dinnername from prizedraw.dinnerlist")
    List<String> listPrizeDraw();
}
