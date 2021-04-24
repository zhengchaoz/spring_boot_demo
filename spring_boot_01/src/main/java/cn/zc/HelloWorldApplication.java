package cn.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  @Target(ElementType.TYPE)
 *  @Retention(RetentionPolicy.RUNTIME)
 *  @Documented
 *  @Inherited
 *  @SpringBootConfiguration
 *  @EnableAutoConfiguration
 *  @ComponentScan(excludeFilters = {
 *          @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 *          @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 *  public @interface SpringBootApplication {}
 *
 *  @SpringBootConfiguration： spring boot的配置类
 *          @Configuration： 配置类上来标注这个注解，类似之前的xml配置文件
 *
 * @EnableAutoConfiguration： 开启自动配置功能
 *          @Import(EnableAutoConfigurationImportSelector.class)： 导入组件
 *          EnableAutoConfigurationImportSelector：导入组件的选择器；
 *          其父类AutoConfigurationImportSelector.selectImports方法将所有需要导入的组件以全类名的方式返回；这些组件会被添加到容器中
 *          会给容器中导入非常多的自动配置类（xxxxAutoConfiguration），就是给容器中导入这个场景所需要的所有组件，并配置好这些组件
 *          selectImports()方法中调用getCandidateConfigurations()方法，该方法中有SpringFactoriesLoader.loadFactoryNames(
 * 			EnableAutoConfiguration.class, ClassLoader)，从loadFactoryNames()中得到FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories"
 *          即spring boot在启动时会从该路径下获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中
 *          @AutoConfigurationPackage： 自动配置包
 *              @Import(AutoConfigurationPackages.Registrar.class)： 给容器中导入一个组件，
 *                  导入的组件由AutoConfigurationPackages类指定，该类中的Registrar方法通过new PackageImport(metadata).getPackageName()
 *                  来将主配置类（被@SpringBootApplication标注）的所在包及其子包里面的所有组件扫描到spring中
 *
 */
@SpringBootApplication// 来标注一个主程序类，来说明这是一个spring boot应用
public class HelloWorldApplication {

    public static void main(String[] args) {
        // spring应用启动，run()的.class参数必须声明@SpringBootApplication注解
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
