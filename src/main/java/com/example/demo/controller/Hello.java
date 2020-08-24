package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Hello {

    private Map<String ,Object> parms = new HashMap<String,Object>();
    @RequestMapping("/hello")
    public String run(){
        System.out.println("111");
        return "111";
    }

    /**
     * 测试路径获取字段
     */
    @RequestMapping(path="/{city_id}/{user_id}",method= RequestMethod.GET)
    public Object find(@PathVariable("city_id")String city, @PathVariable("user_id")String user){
        parms.clear();
        parms.put("city",city);
        parms.put("user",user);
        return parms;
    }

   /* 测试getmapping*/
    @GetMapping("/test1")
    public  Object test(int n,int m){
        parms.clear();
        parms.put("n",n);
        parms.put("m",m);
        return parms;
    }

   /*默认值*/
    @GetMapping("/test2")
    public  Object test2(@RequestParam(defaultValue = "0",required = true,name = "page") int n ,int m){
        parms.clear();
        parms.put("n",n);
        parms.put("m",m);
        return parms;
    }

    /*HttpServletRequest*/
    @GetMapping("/test3")
    public  Object request(HttpServletRequest request){
        parms.clear();
        parms.put("n",request.getParameter("n"));
        return parms;
    }
}
