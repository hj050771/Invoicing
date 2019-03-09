package com.dj.invoi.service;

import com.dj.invoi.pojo.PageInfo;
import com.dj.invoi.pojo.Sale;

import java.util.List;
import java.util.Map;

/**
 * @author 黄军
 * @description
 * @date Criate int 16:01 2018/7/21
 * @tel 15377373777
 */
public interface SaleService {
    public Map<String,Object> findSaleList(int page,String ord);

    public boolean addSale(Sale sale);
}
