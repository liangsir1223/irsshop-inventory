package com.iresearch.irsshop.inventory.mapper;

import org.springframework.stereotype.Repository;

import com.iresearch.irsshop.inventory.domain.User;

@Repository
public interface UserMapper {

	public User findUserInfo();
	
}
