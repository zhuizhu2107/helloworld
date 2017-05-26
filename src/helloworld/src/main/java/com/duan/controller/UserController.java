package com.duan.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.duan.bean.User;

public interface UserController {
	
	/**
	 * 用户登陆方法
	 */
	public String login(HttpServletRequest request,HttpServletResponse response,User user,RedirectAttributes redirectAttributes);
	
	
	/**
	 * 用户注册方法
	 */
	public Map<String, Object> register(HttpServletRequest request,HttpServletResponse response,User user,RedirectAttributes redirectAttributes);
	
	
	/**
	 * 用户注册时，检查是否已经存在该用户名
	 */
	public String checkUserNameExists(String userName);
}
