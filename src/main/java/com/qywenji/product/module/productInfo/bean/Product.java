package com.qywenji.product.module.productInfo.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CAI_GC on 2016/12/16.
 */
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*商品id*/
    private Integer id;
    /*商品名*/
    private String productName;
    /*商品短名*/
    private String productNickname;
    /*商品状态*/
    private Integer status;
    /*商品库存*/
    private Integer quantity;
    /*商品单价*/
    private Float price;
    /*商品打折价*/
    private Float discoutPrice;
    /*商品描述*/
    private String description;
    /*店铺id*/
    private Integer webstoreId;
    /*商品创建时间*/
    private Date createTime;
    /*商品最后更新时间*/
    private Date lastUpdateTime = new Date();
    /*商品供应商id*/
    private Integer mid;
    /*商品送货提示（预留字段）*/
    private String deliveryTip;
    /*商品类型*/
    private Integer prodcutTypeId;
    /*商品品牌名（预留字段）*/
    private String brandName;

    private String largeImageUrl;

    private String longDescription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNickname() {
        return productNickname;
    }

    public void setProductNickname(String productNickname) {
        this.productNickname = productNickname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscoutPrice() {
        return discoutPrice;
    }

    public void setDiscoutPrice(Float discoutPrice) {
        this.discoutPrice = discoutPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWebstoreId() {
        return webstoreId;
    }

    public void setWebstoreId(Integer webstoreId) {
        this.webstoreId = webstoreId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getDeliveryTip() {
        return deliveryTip;
    }

    public void setDeliveryTip(String deliveryTip) {
        this.deliveryTip = deliveryTip;
    }

    public Integer getProdcutTypeId() {
        return prodcutTypeId;
    }

    public void setProdcutTypeId(Integer prodcutTypeId) {
        this.prodcutTypeId = prodcutTypeId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
