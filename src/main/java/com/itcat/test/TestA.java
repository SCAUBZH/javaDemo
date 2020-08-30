package com.itcat.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class TestA {
    @Autowired
    Test a;
    public TestA() {
        System.out.println("Test: "+a);
    }
}
