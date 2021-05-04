package com.web.demo.config;

import com.web.demo.filter.MyFilter;
import com.web.demo.listener.MyListener;
import com.web.demo.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * @author 郑超
 * @date 2021-05-04 14:36
 */
@Configuration
public class MyServletConfig {

    // 定制嵌入式的Servlet容器相关的规则
    // 定制tomcat相关的规则：TomcatConnectorCustomizer
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return (factory) -> {
            factory.setPort(8080);
        };
    }

    // 注册三大组件之Servlet
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
    }

    // 注册三大组件之Filter
    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new MyFilter());
        filter.setUrlPatterns(Arrays.asList("/Hi", "/myServlet"));
        return filter;
    }

    // 注册三大组件之Listener
    @Bean
    public ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new MyListener());
    }
}
