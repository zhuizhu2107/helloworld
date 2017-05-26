package com.duan.service.common.impl;

import java.io.Serializable;

import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.duan.common.dao.BaseDao;
import com.duan.service.common.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T>{

	//注入通用dao接口
	@Autowired
	private BaseDao<T> baseDao;
	
	@Override
	public Serializable saveEntity(T t) {
		return baseDao.saveEntity(t);
	}

	@Override
	public T getEntityById(Serializable id) {
		return baseDao.getEntityById(id);
	}

	@Override
	public T getEntityByHqlProperty(String column, String value) {
		return baseDao.getEntityByHqlProperty(column, value);
	}

	@Override
	public T getEntityBySqlProperty(String tableName, String colName, String colValue) {
		return baseDao.getEntityBySqlProperty(tableName, colName, colValue);
	}

	@Override
	public T getEntityByHqlWhere(String sqlWhere, Object[] values, Type[] types) {
		return baseDao.getEntityByHqlWhere(sqlWhere, values, types);
	}

	@Override
	public T getEntityBySqlWhere(String tableName, String sqlWhere, Object[] values, Type[] types) {
		return baseDao.getEntityBySqlWhere(tableName, sqlWhere, values, types);
	}
	
}
