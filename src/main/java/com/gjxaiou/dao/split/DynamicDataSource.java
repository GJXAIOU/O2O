package com.gjxaiou.dao.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * AbstractRoutingDataSource 是 Spring 提供的读写分离的类，然后我们需要实现里面的抽象方法
 * @author GJXAIOU
 * @create 2019-10-29-21:54
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        // 这里通过一个方法返回不同的 key 来区分不同的数据源
        return DynamicDataSourceHolder.getDbType();
    }
}