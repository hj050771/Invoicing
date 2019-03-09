package com.dj.invoi.service.impl;

import com.dj.invoi.mapper.ProductMapper;
import com.dj.invoi.mapper.SaleMapper;
import com.dj.invoi.pojo.Ord;
import com.dj.invoi.pojo.PageInfo;
import com.dj.invoi.pojo.Product;
import com.dj.invoi.pojo.Sale;
import com.dj.invoi.service.SaleService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黄军
 * @description
 * @date Criate int 16:04 2018/7/21
 * @tel 15377373777
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleMapper saleMapper;

    @Resource
    private ProductMapper productMapper;

    @Override
    public boolean addSale(Sale sale) {
        int i = saleMapper.saveSale(sale);
        Product product = new Product();
        product.setId(sale.getProductId());
        product.setQuantity(sale.getQuantity());
        int cnt = productMapper.updateProduct(product);
        if (i==1&&cnt==1){
            System.out.println("添加成功");
            return true;
        }
        return false;
    }

    @Override
    public Map<String,Object> findSaleList(int page,String ord) {
        Map<String,Object> map = new HashMap<>();
        PageInfo<Sale> pageInfo = new PageInfo<Sale>();
        pageInfo.setCurrPageNo(page);
        pageInfo.setPageSize(3);
        int cnt = saleMapper.getCnt();
        pageInfo.setTotalCount(cnt);
        int start = (pageInfo.getCurrPageNo()-1)*pageInfo.getPageSize();
        List<Sale> saleList = saleMapper.getAllSale(start,pageInfo.getPageSize(),ord);
        pageInfo.setObjList(saleList);
        List<Ord> ordList = saleMapper.getOrdList();
        map.put("pageInfo",pageInfo);
        map.put("ordList",ordList);
        return map;
    }
}
