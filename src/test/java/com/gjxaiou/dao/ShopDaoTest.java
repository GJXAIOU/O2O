package com.gjxaiou.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import com.gjxaiou.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gjxaiou.entity.Area;
import com.gjxaiou.entity.PersonInfo;
import com.gjxaiou.entity.Shop;
import com.gjxaiou.entity.ShopCategory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShopDaoTest extends BaseTest {

	@Autowired
	private ShopDao shopDao;

	@Test
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();

		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);

		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试店铺");
		shop.setShopDesc("DESC TEST");
		shop.setPhone("13012345678");
		shop.setShopImg("test.img");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");

		int result = shopDao.insertShop(shop);
		assertEquals(1, result);
	}

	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopAddr("修改新的地址");
		shop.setShopDesc("测试修改一下描述");
		shop.setLastEditTime(new Date());

		int result = shopDao.updateShop(shop);

		assertEquals(1, result);
	}

	@Test
	public void testQueryByShopId() {
		long shopId = 1l;
		Shop shop = shopDao.queryByShopId(shopId);
		log.info("areaId:" + shop.getArea().getAreaId());
		log.info("areaName:" + shop.getArea().getAreaName());
		assertNotNull(shop);
	}

	@Test
	public void testQueryShopList() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1l);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);

		int count = shopDao.queryShopCount(shopCondition);

		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(2l);
		shopCondition.setShopCategory(sc);
		List<Shop> shopList2 = shopDao.queryShopList(shopCondition, 0, 10);

		assertEquals(5, shopList.size());
		assertTrue(count > 20);
		assertEquals(6l, shopList2.size());
	}

	@Test
	public void testQueryShopListParent() {
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(1l);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);

		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 99);

		assertEquals(9, shopList.size());
	}
	
	@Test
	public void testQueryShopListByName() {
		Shop shopCondition = new Shop();
		shopCondition.setShopName("兔宝宝");
		List<Shop> result = shopDao.queryShopList(shopCondition, 0, 99);
		assertEquals(1, result.size());
		
	}

}
