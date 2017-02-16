package com.qywenji.product.module.productItemInfo.dao;

import com.qywenji.product.commons.dao.BaseDao;
import com.qywenji.product.module.productItemInfo.bean.ProductItem;
import org.springframework.stereotype.Repository;

/**
 * Created by CAI_GC on 2016/12/16.
 */
@Repository
public class ProductItemDao extends BaseDao<ProductItem> {


    public void delByProductId(Integer productId) {
        String sql = "delete from product_item where product_id=:productId";
        super.currentSession().createSQLQuery(sql).setParameter("productId",productId).executeUpdate();
    }

    public ProductItem getByItemId(Integer itemId) {
        String hql = "from ProductItem where itemId = ?";
        return super.get(hql,itemId);
    }
}
