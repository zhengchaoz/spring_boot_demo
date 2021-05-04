package com.web.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 郑超
 * @date 2021-05-04 14:42
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
