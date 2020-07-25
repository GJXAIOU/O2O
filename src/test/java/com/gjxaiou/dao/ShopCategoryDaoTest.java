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

		ShopCategory testShopCategory = new ShopCategory();

		testShopCategory.setShopCategoryId(11l);

		List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(testShopCategory);
		assertEquals(12, shopCategories.size());
	}

	@Test
	public void testQueryShopCategoryNull() {
		List<ShopCategory> result = shopCategoryDao.queryShopCategory(null);
		assertEquals(3, result.size());
	}
}
