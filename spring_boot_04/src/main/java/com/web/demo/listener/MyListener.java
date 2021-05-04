package com.web.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 郑超
 * @date 2021-05-04 14:48
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Destroy...");
    }
}
