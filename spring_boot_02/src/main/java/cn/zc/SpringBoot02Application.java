package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * spring boot 会从以下路径扫描全局配置文件application.properties或application.yml，优先级从高到低
 * - file: ./config/
 * - file: ./
 * - classpath: /config/
 * - classpath: /
 * 以上四个路径内的文件都会加载一边，依次加载过程中，如有相同属性，高优先级会覆盖低优先级
 * 这样不同优先级的文件相互之间形成了：互补配置
 *
 * 项目打包好后，通过命令行spring.config.location的形式，启动项目是指定配置文件的新位置，
 * 和默认加载的这些配置文件共同形成互补配置
 */
//@ImportResource(locations = {"classpath:xxxx.xml"})用来导入自定义的spring配置文件（.xml），必须放在配置类上
@SpringBootApplication
public class SpringBoot02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02Application.class, args);
    }

}
