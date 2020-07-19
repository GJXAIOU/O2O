package com.gjxaiou.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gjxaiou.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.gjxaiou.entity.ProductImg;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {

	@Autowired
	private ProductImgDao productImgDao;

	@Test
	public void testABatchInsertProductImg() throws Exception {
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("图片1");
		productImg1.setImgDesc("测试图片1");
		productImg1.setPriority(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(16l);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg1.setImgDesc("测试图片2");
		productImg2.setPriority(1);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(16l);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
	}

	@Test
	public void testBQueryProductImgList() {
		List<ProductImg> productImgList = productImgDao.queryProductImgList(16);
		assertEquals(2, productImgList.size());
	}

	@Test
	public void testCDeleteProductImgByProductId() throws Exception {
		long productId = 16;
		int effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
	}

}
