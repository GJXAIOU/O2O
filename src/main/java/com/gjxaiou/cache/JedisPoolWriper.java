package com.gjxaiou.cache;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description: 强指定redis的JedisPool接口构造函数，这样才能在centos成功创建jedispool
 */
public class JedisPoolWriper {
	// Redis 连接池对象
	private JedisPool jedisPool;

	/**
	 * 初始化连接池对象
	 * @param poolConfig ：配置好的连接池配置信息
	 * @param host：服务器 IP
	 * @param port：Redis 端口：6379
	 */
	public JedisPoolWriper(final JedisPoolConfig poolConfig, final String host, final int port) {
		try {
			jedisPool = new JedisPool(poolConfig, host, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
}
