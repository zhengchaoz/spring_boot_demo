package cn.zc.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 *                 @ConfigurationProperties         @Value
 *                 批量注入配置文件中的属性             一个个指定
 * SpEl            不支持                            支持 #{11*2}
 * JSR303数据校验   支持                              不支持
 * 复杂类型封装      支持                              不支持
 * 用途            和JavaBean映射时使用                为单一业务属性赋值时使用
 *
 * @author 郑超
 * @date 2021-04-24 11:11
 */
// @ConfigurationProperties告诉spring boot将本类中的属性和配置文件中的相关属性进行绑定
// prefix="person" 配置文件中的那个下面的所有属性一一映射
//@PropertySource(value = {"classpath:person.properties"})// 加载指定配置文件
@Component
@ConfigurationProperties(prefix = "person")// 默认加载全局配置文件application.properties或application.yml
//@Validated
public class Person {

//    @Value("${person.name}")
//    @Email
    private String name;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String, Object> map;
    private List<Object> list;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("boss=" + boss)
                .add("birth=" + birth)
                .add("map=" + map)
                .add("list=" + list)
                .add("dog=" + dog)
                .toString();
    }
}
