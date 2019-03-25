package com.sunli.sale.controller;

import com.github.pagehelper.PageInfo;
import com.sunli.sale.domain.PreviousSale;
import com.sunli.sale.dto.reqDTO.PreviousSaleSelectListDTO;
import com.sunli.sale.service.PreviousSaleService;
import com.sunli.sale.utils.resultUtil.ResultMsg;
import com.sunli.sale.utils.resultUtil.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rest/previous/sale")
public class PreviousSaleController {
    @Resource
    private PreviousSaleService previousSaleService;
    @PostMapping("/insert/list")
    public ResultMsg insertList(@RequestBody PreviousSale previousSale){
        return ResultUtil.success(previousSaleService.insert(previousSale));
    }
    @PostMapping("/select/list")
    public ResultMsg selectList(@RequestBody PreviousSaleSelectListDTO dto){
        PageInfo<PreviousSale> previousSalePageInfo = previousSaleService.selectList(dto);
        return ResultUtil.success(previousSalePageInfo);
    }
    @PostMapping("/update/one")
    public ResultMsg updateOne(@RequestBody PreviousSale previousSale){
        int i = previousSaleService.updateOne(previousSale);
        return ResultUtil.success(i);
    }

    @GetMapping("/delete/one")
    public ResultMsg deleteOne(Integer id){
        int i = previousSaleService.deleteOne(id);
        return ResultUtil.success(i);
    }
}