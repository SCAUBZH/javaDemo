package com.itcat;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * 容器初始化之前，从parameter中加载远程参数
 * */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ckt is a good man.");

        Properties properties = new Properties();
        properties.put("name","ckt");
        properties.put("age_haha","fdasfdas");
        properties.put("sex","man");

        PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("remote", properties);
        applicationContext.getEnvironment().getPropertySources().addFirst(propertiesPropertySource);

    }

}
