package com.iresearch.irsshop.inventory.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.iresearch.irsshop.inventory.dao.RedisDAO;
import com.iresearch.irsshop.inventory.domain.User;
import com.iresearch.irsshop.inventory.mapper.UserMapper;

@Service("userService")  
public class UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private RedisDAO redisDAO;
	
	public User findUserInfo() {
		return userMapper.findUserInfo();
	}

	public User getCachedUserInfo() {
		redisDAO.set("cached_user_lisi", "{\"name\": \"lisi\", \"age\":28}");
		
		String userJSON = redisDAO.get("cached_user_lisi");  
		JSONObject userJSONObject = JSONObject.parseObject(userJSON);
		
		User user = new User();
		user.setName(userJSONObject.getString("name"));   
		user.setAge(userJSONObject.getInteger("age"));  
		
		return user;
	}

}
