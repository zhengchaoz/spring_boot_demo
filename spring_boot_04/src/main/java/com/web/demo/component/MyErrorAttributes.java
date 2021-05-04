package com.web.demo.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author 郑超
 * @date 2021-05-04 11:23
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("hi", "zhengchao");
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.putAll(ext);
        return map;
    }
}
