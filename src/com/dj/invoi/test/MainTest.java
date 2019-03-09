package com.dj.invoi.test;

import com.dj.invoi.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext ct=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        HelloJop test = ct.getBean("test",HelloJop.class);
       Object userService = ct.getBean("userService");
        System.out.println(test);
        System.out.println(userService);
    }
}
