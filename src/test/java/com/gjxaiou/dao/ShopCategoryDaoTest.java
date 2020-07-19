package com.gjxaiou.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.gjxaiou.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gjxaiou.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
		assertEquals(1, shopCategoryList.size());
		ShopCategory testShopCategory = new ShopCategory();
		ShopCategory parentShopCategory = new ShopCategory();
		parentShopCategory.setShopCategoryId(1l);
		testShopCategory.setParent(parentShopCategory);
		shopCategoryList = shopCategoryDao.queryShopCategory(testShopCategory);
		assertEquals(1, shopCategoryList.size());
	}

	@Test
	public void testQueryShopCategoryNull() {
		List<ShopCategory> result = shopCategoryDao.queryShopCategory(null);
		assertEquals(3, result.size());
	}
}
