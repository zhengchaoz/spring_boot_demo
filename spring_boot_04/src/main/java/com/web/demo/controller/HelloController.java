package com.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 郑超
 * @date 2021-05-03 9:33
 */
@Controller
public class HelloController {

    //在templates模板引擎中寻找index页面
//    @RequestMapping({"/", "/login.html"})
//    public String login() {
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("郑超", "航天", "电话"));
        return "success";
    }
}
