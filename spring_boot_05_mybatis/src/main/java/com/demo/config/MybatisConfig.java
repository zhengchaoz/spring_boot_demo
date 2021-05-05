package com.demo.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 郑超
 * @date 2021-05-05 11:17
 */
@Configuration
public class MybatisConfig {

    // 开启驼峰命名
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return (configuration) -> configuration.setMapUnderscoreToCamelCase(true);
    }

}
