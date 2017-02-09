package com.qywenji.product.module.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qywenji.product.module.productInfo.bean.Product;
import com.qywenji.product.module.productInfo.service.ProductService;
import com.qywenji.product.module.productItemInfo.bean.ProductItem;
import com.qywenji.product.module.productItemInfo.service.ProductItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.List;

/**
 * Created by CAI_GC on 2016/12/22.
 */
@Component
public class ProductQueueMessageListener implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(ProductQueueMessageListener.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductItemService productItemService;

    /**
     * 接收消息
     */
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage mes = (TextMessage) message;
                String text = mes.getText();
                this.handleMes(text);
            } else {
                logger.info("*******此消息有问题！消息类型不是text数据*********");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleMes(String mes) {
        JSONObject jsonObject = JSON.parseObject(mes);
        String type = jsonObject.getString("type");
        String data = jsonObject.getString("data");
        switch (type){
            case "publish":
                this.publish(data);
                break;
            case "cancel":
                this.publishCancel(data);
                break;
            case "delete":
                this.delete(data);
                break;
            default:
                logger.info("没有该消息类型:{}",type);
                break;
        }


    }

    public void publish(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        Product productTemp = JSONObject.parseObject(jsonObject.getString("productJson"),Product.class);
        List<ProductItem> productItemList = JSONObject.parseArray(jsonObject.getString("productItemListJson"), ProductItem.class);

        Product product = productService.getByProductId(productTemp.getProductId());
        if(product == null){
            productService.save(productTemp);
        }else{
            product.setProductId(productTemp.getProductId());
            product.setProductName(productTemp.getProductName());
            product.setProductNickname(productTemp.getProductNickname());
            product.setStatus(productTemp.getStatus());
            product.setQuantity(productTemp.getQuantity());
            product.setPrice(productTemp.getPrice());
            product.setDiscountPrice(productTemp.getDiscountPrice());
            product.setDescription(productTemp.getDescription());
            product.setShopId(productTemp.getShopId());
            product.setCreateTime(productTemp.getCreateTime());
            product.setLastUpdateTime(productTemp.getLastUpdateTime());
            product.setMid(productTemp.getMid());
            product.setDeliveryTip(productTemp.getDeliveryTip());
            product.setProductTypeId(productTemp.getProductTypeId());
            product.setBrandName(productTemp.getBrandName());
            product.setLargeImageUrl(productTemp.getLargeImageUrl());
            product.setLongDescription(productTemp.getLongDescription());
            productService.save(product);
        }
        productItemService.delByProductId(productTemp.getProductId());
        for (ProductItem pItem : productItemList){
            productItemService.save(pItem);
        }
    }
    public void publishCancel(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        Product productTemp = JSONObject.parseObject(jsonObject.getString("productJson"),Product.class);
        List<ProductItem> productItemList = JSONObject.parseArray(jsonObject.getString("productItemListJson"), ProductItem.class);

        Product product = productService.getByProductId(productTemp.getProductId());
        if(product==null){
            return;
        }
        product.setProductId(productTemp.getProductId());
        product.setProductName(productTemp.getProductName());
        product.setProductNickname(productTemp.getProductNickname());
        product.setStatus(productTemp.getStatus());
        product.setQuantity(productTemp.getQuantity());
        product.setPrice(productTemp.getPrice());
        product.setDiscountPrice(productTemp.getDiscountPrice());
        product.setDescription(productTemp.getDescription());
        product.setShopId(productTemp.getShopId());
        product.setCreateTime(productTemp.getCreateTime());
        product.setLastUpdateTime(productTemp.getLastUpdateTime());
        product.setMid(productTemp.getMid());
        product.setDeliveryTip(productTemp.getDeliveryTip());
        product.setProductTypeId(productTemp.getProductTypeId());
        product.setBrandName(productTemp.getBrandName());
        product.setLargeImageUrl(productTemp.getLargeImageUrl());
        product.setLongDescription(productTemp.getLongDescription());
        productService.save(product);
    }

    public void delete(String data){
        JSONObject jsonObject = JSON.parseObject(data);
        Integer productId = jsonObject.getInteger("productId");
        Product product = productService.getByProductId(productId);
        if(product != null){
            productService.del(product);
        }
        productItemService.delByProductId(productId);
    }

}
