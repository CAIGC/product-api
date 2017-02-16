package com.qywenji.product.module.productItemInfo.service;

import com.qywenji.product.commons.service.BaseService;
import com.qywenji.product.module.productItemInfo.bean.ProductItem;
import com.qywenji.product.module.productItemInfo.dao.ProductItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CAI_GC on 2016/12/16.
 */
@Service
public class ProductItemService extends BaseService<ProductItem> {

    @Autowired
    private ProductItemDao productItemDao;

    public void delByProductId(Integer productId) {
        productItemDao.delByProductId(productId);
    }

    public ProductItem getByItemId(Integer itemId){
        return productItemDao.getByItemId(itemId);
    }
}
