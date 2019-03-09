package com.dj.invoi.pojo;

/**
 * @author 黄军
 * @description 销售人员实体类
 * @date Criate int 13:42 2018/7/21
 * @tel 15377373777
 */
public class Users {
    private Integer id;
    private String userName;
    private String password;
    private String realName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
