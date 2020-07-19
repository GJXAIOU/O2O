package com.gjxaiou.util;

/**
 * ShopService 中的 getShopList 方法中传入的是 pageIndex，即前端传入的是页数，但是后端 Mapper 文件中使用的是
 * rowIndex，即行数，因此这里需要进行工具类转换。
 * @author GJXAIOU
 * @create 2019-10-24-16:37
 */
public class PageCalculator {
    // 将 pageIndex 转换为 rowIndex
    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
