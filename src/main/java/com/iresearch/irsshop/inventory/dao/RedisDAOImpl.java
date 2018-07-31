package com.iresearch.irsshop.inventory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository("redisDAO")
public class RedisDAOImpl implements RedisDAO {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}
