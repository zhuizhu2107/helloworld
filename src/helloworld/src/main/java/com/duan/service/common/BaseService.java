package com.duan.service.common;

import java.io.Serializable;

public abstract interface BaseService<T> {
	/**
	 * 添加类方法(保存实体)
	 */
	public Serializable saveEntity(T t);
	
	/**
	 *  通过id获取实体数据
	 * @param id
	 * @return
	 */
	public T getEntityById(Serializable id);
	
	/**
	 * 查询类方法
	 * 单属性查询HQL语句
	 */	
	public T getEntityByHqlProperty(String column,String value);
	
	/**
	 * 查询类方法
	 * 单属性查询SQL语句
	 */	
	public T getEntityBySqlProperty(String tableName,String colName,String colValue);	
	
	/**
	 * 查询类方法
	 * 多属性查询HQL语句
	 */
	public T getEntityByHqlWhere(String sqlWhere,Object[] values, org.hibernate.type.Type[] types);
	
	/**
	 * 查询类方法
	 * 多属性查询SQL语句
	 */
	public T getEntityBySqlWhere(String tableName, String sqlWhere, Object[] values, org.hibernate.type.Type[] types);
	
}
