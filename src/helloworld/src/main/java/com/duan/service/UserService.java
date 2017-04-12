package com.duan.service;

import java.io.Serializable;

import com.duan.bean.User;

/**
 * 用户表Service服务管理类
 */
public interface UserService {
	
	/**
	 *  通过id获取用户信息
	 * @param id
	 * @return
	 */
	public User getEntityById(Serializable id);
	
	/**
	 * 查询类方法
	 * 单属性查询HQL语句
	 */	
	public User getEntityByHqlProperty(String column,String value);
	
	/**
	 * 查询类方法
	 * 单属性查询SQL语句
	 */	
	public User getEntityBySqlProperty(String tableName,String colName,String colValue);	
	
	/**
	 * 查询类方法
	 * 多属性查询HQL语句
	 */
	public User getEntityByHqlWhere(String sqlWhere,Object[] values, org.hibernate.type.Type[] types);
	
	/**
	 * 查询类方法
	 * 多属性查询SQL语句
	 */
	public User getEntityBySqlWhere(String tableName, String sqlWhere, Object[] values, org.hibernate.type.Type[] types);
	
}
