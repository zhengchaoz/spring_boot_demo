## spring boot web模块
* 问题：这个场景spring boot帮我们配置了什么？能不能修改？能修改哪些？能不能拓展？
* spring boot在自动配置很多组件的时候，先看容器中有没有用户自己配置的，有就用用户配置的，没有采用默认的
* 在springboot中会有非常多的xxxConfigurer帮组我们进行扩展配置
* 在springboot中会有非常多的xxxCustomizer帮助我们进行定制配置

### 功能模块
* 扩展springMVC，实现WebMvcConfigurer
* 定义视图映射，重写addViewControllers，实现登录请求的页面映射
* 自定义国际化解析器，实现LocaleResolver，然后重写resolveLocale，方法名必须为localeResolver
* 实现登录后重定向至主页面，并注册自定义拦截器，对访问主页面的请求金拦截，对静态资源和登录相关请求放行
* 使用[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.pdf)模板引擎进行crud的页面开发
* 利用[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.pdf)模板引擎进行公共页面元素的抽取（th:fragment、id选择器和th:insert、replace、include）
* 定制错误页面(模板引擎：/error/404.html ... 或静态资源下)和错误数据(1.自定义异常处理器@ControllerAdvice 2.@ExceptionHandler处理对应的异常 
  3.将自定义错误数据加入默认的异常处理器中，重写org.springframework.boot.web.servlet.error.DefaultErrorAttributes.getErrorAttributes())
* 注册Servlet三大组件xxxRegistrationBean

### 嵌入式的Servlet容器
* 如何定制和修改Servlet容器的相关配置
  * 通过修改springboot配置文件：
    * 通用的Servlet容器设置：server.xxx
    * 通用的Tomcat容器设置：server.tomcat.xxx
  * 实现WebServerFactoryCustomizer<ConfigurableServletWebServerFactory 或 TomcatConnectorCustomizer>，并重写其方法
* springboot能不能支持其它的Servlet容器
  * 其它Servlet容器：Jetty（长连接，web聊天）、Undertow（不支持jsp，高性能非阻塞，并发性能好）、Netty
  * 先排除内置的tomcat的jar包依赖，在引入其它Servlet容器依赖

``` html
<footer th:fragment="copy">
    &copy; 2011 The Good Thymes Virtual Grocery
</footer>

<div th:insert="footer :: copy"></div>
<div th:replace="footer :: copy"></div>
<div th:include="footer :: copy"></div>

<div>
    <footer>
        &copy; 2011 The Good Thymes Virtual Grocery
    </footer>
</div>
<footer>
    &copy; 2011 The Good Thymes Virtual Grocery
</footer>
<div>
    &copy; 2011 The Good Thymes Virtual Grocery
</div>
```

### web映射规则
``` java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
  if (!this.resourceProperties.isAddMappings()) {
    logger.debug("Default resource handling disabled");
    return;
  }
  Integer cachePeriod = this.resourceProperties.getCachePeriod();
  if (!registry.hasMappingForPattern("/webjars/**")) {
    customizeResourceHandlerRegistration(
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations(
                "classpath:/META-INF/resources/webjars/")
        .setCachePeriod(cachePeriod));
  }
  String staticPathPattern = this.mvcProperties.getStaticPathPattern();
  if (!registry.hasMappingForPattern(staticPathPattern)) {
    customizeResourceHandlerRegistration(
        registry.addResourceHandler(staticPathPattern)
            .addResourceLocations(
                this.resourceProperties.getStaticLocations())
        .setCachePeriod(cachePeriod));
  }
}
```

### 访问当前项目的静态资源，如果没有处理就默认进入以下目录查找
* `（classpath:代表resources目录，classpath:/resources/就是在resources目录下在创建一个resources）`
* "classpath:/resources/"
* "classpath:/static/"
* "classpath:/public/"
* "/"