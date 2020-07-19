package com.gjxaiou.dto;

import com.gjxaiou.entity.Shop;
import com.gjxaiou.enums.ShopStateEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 操作店铺的返回 dto，存储包括店铺信息和状态值。
 * dto 用于在应用程序的各个子系统之间传输数据，用于存储实体的部分属性和符合传输需求的其它属性
 *
 * @author GJXAIOU
 * @create 2019-11-02-9:25
 */
@Setter
@Getter
public class ShopExecution {


    /**
     * 店铺状态值和状态值的含义，状态是枚举类型的值
     */
    private int state;
    private String stateInfo;
    /**
     * 店铺数量
     */
    private int count;
    /**
     * 操作的 shop（增删改店铺时候使用）
     */
    private Shop shop;
    /**
     * 获取 shop 列表，在查询列表时候使用
     */
    private List<Shop> shopList;


    /**
     * 无参构造方法
     */
    public ShopExecution() {
    }

    /**
     * 店铺操作失败对应的构造方法，获取状态值和状态信息
     *
     * @param shopStateEnum
     */
    public ShopExecution(ShopStateEnum shopStateEnum) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    /**
     * 店铺操作成功使用的构造器，返回 shop 对象和状态
     *
     * @param shopStateEnum
     * @param shop
     */
    public ShopExecution(ShopStateEnum shopStateEnum, Shop shop) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     * 店铺操作成功使用的构造器，返回 shop 列表和对象
     *
     * @param shopStateEnum
     * @param shopList
     */
    public ShopExecution(ShopStateEnum shopStateEnum, List<Shop> shopList) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shopList = shopList;
    }


    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

}
