package org.chen2lei.core.db;

import java.io.IOException;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCache {

	private static JedisPool pool;

	static {

		Properties prop = new Properties();
		try {
			prop.load(RedisCache.class
					.getResourceAsStream("redis_config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JedisPoolConfig poolConfig = new JedisPoolConfig();
		pool = new JedisPool(poolConfig, prop.getProperty("server_ip1"));

	}

	public static Jedis getJedis() {
		return pool.getResource();
	}
}
