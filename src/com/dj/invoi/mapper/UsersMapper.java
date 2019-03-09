package com.dj.invoi.mapper;

import com.dj.invoi.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author 黄军
 * @description 用户信息数据访问层接口
 * @date Criate int 14:02 2018/7/21
 * @tel 15377373777
 */
@Component
public interface UsersMapper {
    /**
     * description 根据用户名和密码查询用户信息
     * @param: userName 用户名 password 密码
     * @return: Users 对象
     * @auther: 黄军
     * @date: 2018/7/21 14:06
     */
    public Users getUserByName(@Param("userName")String userName,@Param("password")String password);
}
