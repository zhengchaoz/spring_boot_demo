package cn.zc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑超
 * @date 2021-04-24 15:07
 */
@RestController
public class HelloNameController {

    @Value("${person.name:zc}")
    private String name;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "hello " + name;
    }
}
