package com.duan.common.dao;

import java.io.Serializable;
import java.util.List;

public abstract interface BaseDao<T> {
	/**
	 * 添加类方法(保存实体)
	 */
	public Serializable saveEntity(T t);
	
	/**
	 * 添加类方法(保存实体集合)
	 */
	public int saveEntityList(List<T> list);
	
	
	/**
	 * 删除类方法
	 */
	public void delete();
	
	/**
	 * 更新类方法
	 */
	public void update();
	
	/**
	 * 查询类方法
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
	public T getEntityBySqlWhere(String tableName,String sqlWhere,Object[] values, org.hibernate.type.Type[] types);
	
	
	public T load(Serializable id);
	
	public List<T> find(String column,String value);
	public List<T> find(String sqlWhere);
	
	/**
	 * 统计类方法
	 */	
	public void total();
	
	
	/**
	 * 执行类类方法
	 */	
	public void execute();
	
}
