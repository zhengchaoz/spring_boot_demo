package cn.zc;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot03ApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        // 日志级别由低到高
        logger.trace("这是trace");
        logger.debug("这是debug");
        // spring boot默认输出info及更高级别的日志
        logger.info("这是info");
        logger.warn("这是warn");
        logger.error("这是error");
    }

}
