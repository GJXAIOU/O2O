package com.gjxaiou.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 因为不能直接访问 WEB_INF 下面的页面，所有需要通过 SpringMVC 进行转发
 * @author GJXAIOU
 * @create 2019-11-05-15:28
 */
@Controller
@RequestMapping(value = "/shopadmin", method = {RequestMethod.GET})
public class shopAdminController {

    /**
     * 转发至店铺注册/编辑页面
     *
     * @return
     */
    // 返回一个字符串，告诉转发至哪一个 HTML 页面
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        // 因为在 spring-web 中已经配置了前后缀
        return "shop/shopoperation";
    }

    /**
     * 转发至店铺列表页面
     *
     * @return
     */
    @RequestMapping(value = "/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    /**
     * 转发至店铺管理页面
     *
     * @return
     */
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

    /**
     * 转发至商品类别管理页面
     *
     * @return
     */
    @RequestMapping(value = "/productcategorymanagement")
    public String productCategoryManagement() {
        return "shop/productcategorymanagement";
    }

    /**
     * 转发至商品添加/编辑页面
     *
     * @return
     */
    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        return "shop/productoperation";
    }

    /**
     * 转发至商品添加/编辑页面
     *
     * @return
     */
    @RequestMapping(value = "/productmanagement")
    public String productManagement() {
        return "productmanagement";
    }
}
