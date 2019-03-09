package com.dj.invoi.controller;

import com.dj.invoi.pojo.PageInfo;
import com.dj.invoi.pojo.Sale;
import com.dj.invoi.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 黄军
 * @description
 * @date Criate int 16:09 2018/7/21
 * @tel 15377373777
 */
@Controller
public class SaleController {
    @Resource
    private SaleService saleService;
    @RequestMapping("selectSale.htmls")
    @ResponseBody
    public Object getSale(HttpServletRequest req, @RequestParam(value = "page",defaultValue = "1")Integer page,@RequestParam(value = "ord",defaultValue = "salDate")String ord){
        Map<String,Object> map = saleService.findSaleList(page,ord);
       map.put("ordl",ord);
        return map;
    }
    @RequestMapping("addSale.htmls")
    @ResponseBody
    public Object addSale(Sale sale){
        Boolean result = false;
        if (saleService.addSale(sale)){
            result=true;
        }
        return result;
    }
}
