package com.dj.invoi.mapper;

import com.dj.invoi.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 黄军
 * @description
 * @date Criate int 15:18 2018/7/21
 * @tel 15377373777
 */
@Component
public interface ProductMapper {
    @Select("SELECT id,productName,quantity FROM product where quantity=#{quantity} and case when #{productName}!='null' then productName=#{productName} else 1=1 end")
    public List<Product> getAllProduct(Map<String,String> map);

    public int updateProduct(Product product);
}
