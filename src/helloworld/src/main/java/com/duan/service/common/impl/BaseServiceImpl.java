package com.duan.service.common.impl;

import java.io.Serializable;

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
	
	
}
