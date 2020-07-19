package com.gjxaiou.web.frontend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/frontend", method={RequestMethod.GET})
public class FrontController {

	/**
	 * 首页路由
	 */
	@RequestMapping(value = "/index")
	private String index() {
		return "frontend/index";
	}

	/**
	 * 店铺列表路由
	 */
	@RequestMapping(value = "/shoplist")
	private String shopList() {
		return "shoplist";
	}

	/**
	 * 店铺详情路由
	 */
	@RequestMapping(value = "/shopdetail")
	private String shopDetail() {
		return "shopdetail";
	}

	/**
	 * 商品详情页路由
	 */
	@RequestMapping(value = "/productdetail", method = RequestMethod.GET)
	public String productDetail() {
		return "productdetail";
	}
}

