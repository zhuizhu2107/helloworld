package com.duan.service.impl;

import java.io.Serializable;

import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duan.bean.User;
import com.duan.dao.UserDao;
import com.duan.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getEntityById(Serializable id) {
		return userDao.getEntityById(id);
	}

	@Override
	public User getEntityByHqlProperty(String column, String value) {
		// TODO Auto-generated method stub
		return userDao.getEntityByHqlProperty(column, value);
	}

	@Override
	public User getEntityByHqlWhere(String sqlWhere, Object[] values, Type[] types) {
		// TODO Auto-generated method stub
		return userDao.getEntityByHqlWhere(sqlWhere, values, types);
	}

	@Override
	public User getEntityBySqlProperty(String tableName, String colName, String colValue) {
		return userDao.getEntityBySqlProperty(tableName, colName, colValue);
	}

	@Override
	public User getEntityBySqlWhere(String tableName, String sqlWhere, Object[] values, Type[] types) {
		return userDao.getEntityBySqlWhere(tableName, sqlWhere, values, types);
	}
	
	
}
