package com.web.demo.component;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，登陆检查
 *
 * @author 郑超
 * @date 2021-05-03 17:06
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (ObjectUtils.isEmpty(loginUser)) {
            request.setAttribute("msg", "请先登录！");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        } else
            return true;
    }
}
