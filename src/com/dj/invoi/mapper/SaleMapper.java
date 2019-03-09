package com.dj.invoi.mapper;

import com.dj.invoi.pojo.Ord;
import com.dj.invoi.pojo.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 黄军
 * @description
 * @date Criate int 15:41 2018/7/21
 * @tel 15377373777
 */
public interface SaleMapper {
    /**
     * description 查询所有销售记录信息
     * @param:
     * @return:
     * @auther: 黄军
     * @date: 2018/7/21 15:42
     */
    public List<Sale> getAllSale(@Param("start") int start,@Param("size") int size,@Param("ord")String ord);

    public int getCnt();

    public List<Ord> getOrdList();

    public int saveSale(Sale sale);
}
