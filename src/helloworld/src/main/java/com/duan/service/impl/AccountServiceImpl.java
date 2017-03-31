package com.duan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duan.bean.Account;
import com.duan.dao.AccountDao;
import com.duan.service.AccountService;

@Service("accountService")
public class AccountServiceImpl  implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void save(Account account) {
		accountDao.save(account);
	}
	
}
