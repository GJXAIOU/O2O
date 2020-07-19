package com.gjxaiou.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.gjxaiou.BaseTest;
import com.gjxaiou.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(4, areaList.size());
    }

}
