package com.gjxaiou.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gjxaiou.BaseTest;
import com.gjxaiou.entity.ShopCategory;

public class ShopCategoryServiceTest extends BaseTest {

	@Autowired
	private ShopCategoryService shopCategoryService;

	@Test
	public void testGetShopCategoryList() {
		List<ShopCategory> shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
		assertEquals(2, shopCategoryList.size());
	}
}
