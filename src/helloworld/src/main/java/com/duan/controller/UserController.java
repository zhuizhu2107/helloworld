package com.duan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duan.bean.User;

public interface UserController {
	
	/**
	 * 用户登陆方法
	 */
	public String login(HttpServletRequest request,HttpServletResponse response,User user);
}
