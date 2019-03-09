package com.dj.invoi.service;

import com.dj.invoi.pojo.Product;
import com.dj.invoi.pojo.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 黄军
 * @description
 * @date Criate int 14:07 2018/7/21
 * @tel 15377373777
 */
@Service
public interface UserService {
    public Users findUser(String userName,String password);

    public List<Product> loadAllProduct(Map<String,String> map);
}
