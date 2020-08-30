package com.itcat.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Test {
    @Value("${name}")
    private String name;

    @Value("${sex}")
    private String testString001;

    @Value("${age.haha}")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void haha() {
        System.out.println("PostConstruct: name="+name);
        System.out.println("PostConstruct: testString001="+testString001);
        System.out.println("PostConstruct: age="+age);
    }


}
