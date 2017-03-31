package com.duan.dao.impl;

import org.springframework.stereotype.Repository;

import com.duan.bean.Account;
import com.duan.common.dao.impl.BaseDaoJdbcTemplateImpl;
import com.duan.dao.AccountDao;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoJdbcTemplateImpl<Account> implements AccountDao {

}
