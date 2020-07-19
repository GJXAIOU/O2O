package com.gjxaiou.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.gjxaiou.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gjxaiou.entity.HeadLine;

public class HeadLineDaoTest extends BaseTest {

	@Autowired
	private HeadLineDao headLineDao;

	@Test
	public void testQueryHeadLine() {
		List<HeadLine> result = headLineDao.queryHeadLine(new HeadLine());
		assertEquals(4, result.size());
	}

}
