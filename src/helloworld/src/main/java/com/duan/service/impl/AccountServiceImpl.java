package com.duan.service.impl;

import org.springframework.stereotype.Service;
import com.duan.bean.Account;
import com.duan.service.AccountService;
import com.duan.service.common.impl.BaseServiceImpl;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account>  implements AccountService{
	
}
