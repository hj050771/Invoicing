package com.dj.invoi.pojo;

/**
 * @author 黄军
 * @description
 * @date Criate int 13:46 2018/7/21
 * @tel 15377373777
 */
public class Sale {
    private Integer id;
    private Double price;
    private Integer quantity;//销售数量
    private Double totalPrice;
    private String salDate;
    private Integer userId;
    private Integer productId;
    private Users users;
    private Product product;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return price*quantity;
    }

//    public void setTotalPrice(Double totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    public String getSalDate() {
        return salDate;
    }

    public void setSalDate(String salDate) {
        this.salDate = salDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
