package com.dj.invoi.test;

import com.dj.invoi.pojo.Product;
import com.dj.invoi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TimerTask {
    @Autowired
    private UserService userService;
    @Scheduled(cron = "0 0/1 * * * ?")//每分钟执行一次
    public void test(){
        Map<String,String> map = new HashMap<>();
        map.put("quantity","4000");
        map.put("productName","纯牛奶");
        List<Product> products = userService.loadAllProduct(map);
        for (Product product : products) {
            System.out.println(product.getId());
        }
        System.out.println("执行");
    }


}
