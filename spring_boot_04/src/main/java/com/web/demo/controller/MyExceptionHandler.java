package com.web.demo.controller;

import com.web.demo.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 郑超
 * @date 2021-05-04 11:08
 */
@ControllerAdvice// 异常处理器
public class MyExceptionHandler {

    // 标注要处理的异常
//    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    public Map<String, Object> handlerException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notExist");
//        map.put("message", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest req) {
        // 设置错误状态码
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notExist");
        map.put("message", "用户出错！");
        req.setAttribute("ext", map);
        req.setAttribute("javax.servlet.error.status_code", 500);
        return "forward:/error";
    }

}
