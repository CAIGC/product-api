package com.qywenji.product.module.productInfo.service;

import com.qywenji.product.commons.service.BaseService;
import com.qywenji.product.module.productInfo.bean.Product;
import com.qywenji.product.module.productInfo.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CAI_GC on 2016/12/16.
 */
@Service
public class ProductService extends BaseService<Product> {

    @Autowired
    private ProductDao productDao;

    public Product getByProductId(Integer productId) {
        return productDao.getByProductId(productId);
    }
}
