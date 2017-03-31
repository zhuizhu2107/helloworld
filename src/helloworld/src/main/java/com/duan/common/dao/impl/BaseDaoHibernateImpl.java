package com.duan.common.dao.impl;

import java.lang.reflect.ParameterizedType;

import com.duan.common.dao.BaseDao;

/**
 * 创建时间 2017年3月30日
 * 作者 段大平
 *通用接口
 */
public abstract class BaseDaoHibernateImpl<T>   implements BaseDao<T> {
	
	protected Class<T> entityClass;
	
	/**
	 * 默认构造方法
	 * 通过反射机制给T对象化
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoHibernateImpl() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("Dao实现类是：" + entityClass.getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void save(T entity) {
      
	}
	
}
