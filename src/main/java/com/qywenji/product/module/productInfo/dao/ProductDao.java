package com.qywenji.product.module.productInfo.dao;

import com.qywenji.product.commons.dao.BaseDao;
import com.qywenji.product.module.productInfo.bean.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by CAI_GC on 2016/12/16.
 */
@Repository
public class ProductDao extends BaseDao<Product> {


    public Product getByProductId(Integer productId) {
       String hql = "from Product where productId = ?";
        return super.get(hql,productId);
    }
}
