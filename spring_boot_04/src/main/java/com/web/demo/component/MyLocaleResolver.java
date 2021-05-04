package com.web.demo.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定国际化解析器，默认是按照请求头信息解析区域信息
 *
 * @author 郑超
 * @date 2021-05-03 15:57
 */
public class MyLocaleResolver implements LocaleResolver {

    // 解析区域信息
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (StringUtils.hasLength(l) && StringUtils.hasText(l)) {
            String[] strings = l.split("_");
            locale = new Locale(strings[0], strings[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
