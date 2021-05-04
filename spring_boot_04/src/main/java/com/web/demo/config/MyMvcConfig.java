package com.web.demo.config;

import com.web.demo.component.LoginHandlerInterceptor;
import com.web.demo.component.MyLocaleResolver;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 扩展springMVC
 *
 * @author 郑超
 * @date 2021-05-03 13:58
 */
//@EnableWebMvc 此注解意味着全面接管springmvc，springboot关于mvc的默认配置失效
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 自定义视图映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送 /zhengc 请求来到 success页面
        // 适用于那种没有和后台交互数据仅仅是跳转页面的场景
        registry.addViewController("/zhengc").setViewName("success");
    }

    // 所有WebMvcConfigurer会一起起作用
    @Bean// 前提是该组件已注册在容器中
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 为首页创建自定的视图映射规则
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册自定义拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // /**拦截任意多层路径的任意请求
                // excludePathPatterns排除以下请求，不拦截
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html", "/", "/user/login", "/asserts/**", "/webjars/**");
            }
        };
    }

    // 自定义国际化解析器，方法名必须为localeResolver
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
