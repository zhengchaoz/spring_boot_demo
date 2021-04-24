package cn.zc.config;

import cn.zc.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 郑超
 * @date 2021-04-24 15:23
 */
@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService() {
        System.out.println("加载配置类helloService...");
        return new HelloService();
    }

}
