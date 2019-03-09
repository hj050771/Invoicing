package com.dj.invoi.controller;

import com.dj.invoi.pojo.Product;
import com.dj.invoi.pojo.Users;
import com.dj.invoi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author 黄军
 * @description
 * @date Criate int 14:14 2018/7/21
 * @tel 15377373777
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("login.htmls")
    public String getUser(String userName, String password, HttpServletRequest req){
        Users users = userService.findUser(userName,password);
         if (users == null){
            return "redirect:/login.jsp";
        }else{
           req.getSession().setAttribute("users",users);
           return "index";
        }
    }
    @RequestMapping("exit.htmls")
    public String exit(HttpServletRequest req){
        req.getSession().invalidate();
        return "login";
    }
    @RequestMapping("add.htmls")
    @ResponseBody
    public Object addSale(HttpServletRequest req){
        List<Product> products = new ArrayList<>();
         Map<String,String> map = new HashMap<>();
         map.put("quantity","4000");
        map.put("productName","纯牛奶");
            products = userService.loadAllProduct(map);

        return products;
    }

}
