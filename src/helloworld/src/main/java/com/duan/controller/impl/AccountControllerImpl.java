package com.duan.controller.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duan.bean.Account;
import com.duan.controller.AccountController;
import com.duan.service.AccountService;
@Controller("accountController")
@RequestMapping(value = "/account")
public class AccountControllerImpl implements AccountController{
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, String> addAccount(Account account) { 
		Map<String, String> map = new HashMap<String, String>(); 
		
		//存储数据
		Date date=new Date();
		account.setAccCreatTime(date);
		account.setAccLoginTime(date);
		accountService.save(account);
		
		map.put("success", "true"); 
		return map;
	}
	
	
}
