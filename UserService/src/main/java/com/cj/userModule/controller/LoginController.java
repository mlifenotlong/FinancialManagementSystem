package com.cj.userModule.controller;




import com.cj.userModule.service.LoginService;
import com.cj.userModule.util.R;
import com.cj.userModule.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
@CrossOrigin()
public class LoginController {
//    @Autowired
//    RedisTemplate redisTemplate;
    @Autowired
LoginService loginService;
    //login
    @PostMapping("login")
    public R login( @RequestBody UserVo userVo){

        
        return loginService.login(userVo);
    }

    @PostMapping("regist")
    public R regist( @RequestBody UserVo userVo){

        return loginService.register(userVo);
    }
    //info
    @GetMapping("info")
    public R getInfo(){
        return    R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://img03.sogoucdn.com/app/a/100520093/d71a6360ba8601ff-19264876bfd6a308-dfbd047d3bb4f2621f01d7ae18979b6e.jpg");


    }
}

