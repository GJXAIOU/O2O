package com.gjxaiou;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置Spring和JUnit整合，JUnit启动时自动加载SpringIOC容器
 *
 * @author Jerry
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml",
        "classpath:spring/spring-redis.xml"})
public class BaseTest {

}
