package cn.zc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑超
 * @date 2021-04-24 10:08
 */
// 这个类的所有返回数据直接写给浏览器，如果是对象就转为json
/*@ResponseBody
@Controller*/
@RestController// == @ResponseBody + @Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "你好！";
    }
    
}
