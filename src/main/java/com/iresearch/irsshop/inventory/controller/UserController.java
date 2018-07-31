package com.iresearch.irsshop.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iresearch.irsshop.inventory.domain.User;
import com.iresearch.irsshop.inventory.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getUserInfo")
	public User getUserInfo() {
		User user = userService.findUserInfo();
		return user;
	}

	@GetMapping("/getCachedUserInfo")
	public User getCachedUserInfo() {
		User user = userService.getCachedUserInfo();
		return user;
	}

}
