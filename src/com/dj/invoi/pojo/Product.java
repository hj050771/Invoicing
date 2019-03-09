package com.dj.invoi.pojo;

/**
 * @author 黄军
 * @description 商品实体类
 * @date Criate int 13:44 2018/7/21
 * @tel 15377373777
 */
public class Product {
    private Integer id;
    private String productName;
    private Integer quantity;//库存总数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
