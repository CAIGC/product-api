package com.qywenji.product.module.productInfo.controller;

import com.qywenji.product.commons.controller.BaseController;
import com.qywenji.product.module.productInfo.bean.Product;
import com.qywenji.product.module.productInfo.bean.ProductDto;
import com.qywenji.product.module.productInfo.constant.ProductConstant;
import com.qywenji.product.module.productInfo.service.ProductService;
import com.qywenji.product.module.productItemInfo.bean.ProductItem;
import com.qywenji.product.module.productItemInfo.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CAI_GC on 2016/12/16.
 */
@RestController
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductItemService productItemService;

    @RequestMapping(value = "/getProductDtoByItemId")
    public Object getProductDtoByItemId(Integer itemId){
        ProductItem productItem = productItemService.getByItemId(itemId);
        if(productItem == null){
            return super.error("没有该规格产品");
        }
        Product product = productService.getByProductId(productItem.getProductId());
        if(product == null){
            return super.error("没有该产品");
        }
        ProductDto productDto = new ProductDto();
        productDto.setItemId(itemId);
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setItemName(productItem.getItemName());
        productDto.setQuantity(productItem.getQuantity());
        productDto.setPrice(productItem.getPrice());
        productDto.setItemTypeId(productItem.getItemTypeId());
        productDto.setItemTypeName(productItem.getItemTypeName());
        productDto.setProductNum(productItem.getProductNum());
        productDto.setItemImageUrl(productItem.getItemImageUrl());
        productDto.setShopId(product.getShopId());
        productDto.setMid(product.getMid());
        productDto.setOnShelf(product.getStatus() == ProductConstant.ON_SHELF?true:false);
        return super.success(productDto);
    }
}
