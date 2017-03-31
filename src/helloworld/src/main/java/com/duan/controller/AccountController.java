package com.duan.controller;

import java.util.Map;

import com.duan.bean.Account;

public interface AccountController {

	/**
	 * 账户新增
	 * @param account
	 * @return
	 */
	public Map<String, String> addAccount(Account account);
	
}
