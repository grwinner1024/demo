package com.example.demo.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Login {
    private Map map = new HashMap();
    @PostMapping ("/login")
    public  Object login(      String userName ,@RequestParam(required = true,name = "pwd")String password){
        String userNameToMd5 = SecureUtil.md5(userName);
        String passwordToMd5 = SecureUtil.md5(password);
        map.clear();
        map.put("userName",userName);
        map.put("password",password);
        map.put("userNameToMd5",userNameToMd5);
        map.put("passwordToMd5",passwordToMd5);
        return map;
    }

    @GetMapping("/testLogin")
    public Object test(){
        map.clear();
        map.put("name", "111");
        map.put("pwd", "222");
        String result= HttpUtil.post("http://localhost:8080/login", map);
        return result;
    }

}
