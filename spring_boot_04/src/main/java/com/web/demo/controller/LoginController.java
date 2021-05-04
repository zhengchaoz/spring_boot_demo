package com.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 郑超
 * @date 2021-05-03 16:31
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (StringUtils.hasLength(username) && "123456".equals(password)) {
            // 登陆成功后，防止表单重复提交需要重定向
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误！");
            return "login";
        }
    }

}
