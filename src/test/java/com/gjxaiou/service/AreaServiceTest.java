package com.gjxaiou.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.gjxaiou.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gjxaiou.entity.Area;

public class AreaServiceTest extends BaseTest {

	@Autowired
	private AreaService areaService;

	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("北京", areaList.get(0).getAreaName());
	}

}
