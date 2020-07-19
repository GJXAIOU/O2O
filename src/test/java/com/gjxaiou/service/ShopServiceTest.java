package com.gjxaiou.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import com.gjxaiou.BaseTest;
import com.gjxaiou.dto.ImageHolder;
import com.gjxaiou.dto.ShopExecution;
import com.gjxaiou.entity.Area;
import com.gjxaiou.entity.PersonInfo;
import com.gjxaiou.entity.Shop;
import com.gjxaiou.entity.ShopCategory;
import com.gjxaiou.enums.ShopStateEnum;
import com.gjxaiou.exception.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShopServiceTest extends BaseTest {

	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() throws FileNotFoundException {
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
		shop.setShopName("我的最新的测试好的");
		shop.setShopDesc("test2");
		shop.setPhone("test2");
		shop.setShopImg("test2.img");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("正在审核中");

		// 这里写我们本地的图片地址
		File shopImg = new File("D:/Picture/Resource/puzzle.png");
		InputStream in = new FileInputStream(shopImg);
		ShopExecution execution = shopService.addShop(shop, new ImageHolder(in, shopImg.getName()));
		// 验证理想值和实际值是否相等
		assertEquals(ShopStateEnum.CHECK.getState(), execution.getState());
	}

	@Test
	public void testModifyShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(35l);
		shop.setShopName("修改了图片的店铺");

		File shopImg = new File("D:/Picture/Resource/avatar.jpg");
		InputStream in = new FileInputStream(shopImg);
		ShopExecution shopExecution = shopService.modifyShop(shop, new ImageHolder(in, "avatar.jpg"));
		log.info("新的图片地址:" + shopExecution.getShop().getShopImg());
		assertEquals("修改了图片的店铺", shopExecution.getShop().getShopName());
	}

	@Test
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(2l);
		shopCondition.setShopCategory(sc);
		ShopExecution se = shopService.getShopList(shopCondition, 1, 4);

		assertEquals(4l, se.getShopList().size());
		assertEquals(6l, se.getCount());
	}
}
