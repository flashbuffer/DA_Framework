package org.chen2lei.core.db;

import redis.clients.jedis.Jedis;

public class RedisTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = RedisCache.getJedis();
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println("******************"+value);
		
		jedis.zadd("slaveMySql", 1.0, "s1");
		jedis.zadd("slaveMySql", 2.0, "s2");
		jedis.zadd("slaveMySql", 3.0, "s3");

		System.out.println("**range*" + jedis.zrange("slaveMySql", 0, 0));
		
		jedis.zincrby("slaveMySql", 1.0, "s1");
		
		System.out.println("**range*" + jedis.zrange("slaveMySql", 0, 0));
		
		jedis.zincrby("slaveMySql", 1.0, "s1");
		
		System.out.println("**range*" + jedis.zrange("slaveMySql", 0, 0));
	}

}
