package com.duan.dao.impl;

import org.springframework.stereotype.Repository;

import com.duan.bean.User;
import com.duan.common.dao.impl.BaseDaoHibernateImpl;
import com.duan.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoHibernateImpl<User> implements UserDao {

}
