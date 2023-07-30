package com.cj.prizeDrawModule.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class R {
    private boolean success;
    private String message;
    private Integer code;
    private Map<String, Object> data = new HashMap<String, Object>();
    public R(){};
    public static R ok(){
        R r=new R();
        r.setSuccess(true);
        r.setMessage("成功");
        r.setCode(ResultCode.SUCCESS);
        return r;
    }
    public static R error(){
        R r=new R();
        r.setSuccess(false);
        r.setMessage("失败");
        r.setCode(ResultCode.ERROR);
        return r;
    }
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R data(Map<String,Object> data){
        this.setData(data);
        return this;
    }
    public R addData(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
