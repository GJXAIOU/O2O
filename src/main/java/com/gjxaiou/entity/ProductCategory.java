package com.gjxaiou.entity;
import	java.awt.Toolkit;

import lombok.*;

import java.util.Date;

/**
 * @author GJXAIOU
 * @create 2019-10-29-22:21
 */
@Getter
@Setter
@ToString
public class ProductCategory {
    private Long productCategoryId;
    private Long shopId;
    private String productCategoryName;
    private String productCategoryDesc;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;

    public ProductCategory() {
    }

    public ProductCategory(Long productCategoryId, Long shopId, String productCategoryName,
                           String productCategoryDesc, Integer priority, Date createTime,
                           Date lastEditTime) {
        this.productCategoryId = productCategoryId;
        this.shopId = shopId;
        this.productCategoryName = productCategoryName;
        this.productCategoryDesc = productCategoryDesc;
        this.priority = priority;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getProductCategoryDesc() {
        return productCategoryDesc;
    }

    public void setProductCategoryDesc(String productCategoryDesc) {
        this.productCategoryDesc = productCategoryDesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
