package com.dj.invoi.test;

import com.dj.invoi.pojo.Product;
import com.dj.invoi.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//让测试运行于Spring环境
@RunWith(SpringJUnit4ClassRunner.class)
//引入Spring配置
@ContextConfiguration({"classpath*:/applicationContext.xml"})
@Component("test")
public class HelloJop {
    @Autowired
    private UserService userService;
   @org.junit.Test
    public void test(){
        Map<String,String> map = new HashMap<>();
        map.put("quantity","4000");
        map.put("productName","纯牛奶");
        List<Product> products = userService.loadAllProduct(map);
        for (Product product : products) {
            System.out.println(product.getId());
        }
        System.out.println("aa");
    }
}
