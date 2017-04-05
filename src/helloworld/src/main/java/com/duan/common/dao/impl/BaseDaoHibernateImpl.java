package com.duan.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.duan.common.dao.BaseDao;

/**
 * 创建时间 2017年3月30日 作者 段大平 通用接口
 * HibernateUtil 工具类
 */
public abstract class BaseDaoHibernateImpl<T> implements BaseDao<T> {

	protected Class<T> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 默认构造方法 通过反射机制给T对象化
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoHibernateImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			this.entityClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
		} else {
			this.entityClass = null;
		}
	}

	/**
	 * 获取session对象
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}	
	
	@Override
	public Serializable save(T entity) {
		return this.getCurrentSession().save(entity);
	}


}
