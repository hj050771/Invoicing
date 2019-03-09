package com.dj.invoi.service.impl;

import com.dj.invoi.mapper.ProductMapper;
import com.dj.invoi.mapper.UsersMapper;
import com.dj.invoi.pojo.Product;
import com.dj.invoi.pojo.Users;
import com.dj.invoi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 黄军
 * @description
 * @date Criate int 14:09 2018/7/21
 * @tel 15377373777
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> loadAllProduct(Map<String,String> map) {
        return productMapper.getAllProduct(map);
    }

    @Override
    public Users findUser(String userName, String password)
    {

        return usersMapper.getUserByName(userName,password);
    }
}
