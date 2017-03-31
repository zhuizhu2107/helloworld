package com.duan.common.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 添加类方法(保存实体)
	 */
	public void save(T t);
	
	/**
	 * 添加类方法(保存实体集合)
	 */
	public void save(List<T> t);
	
	
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
	public void get();
	public void find();
	
	/**
	 * 统计类方法
	 */	
	public void total();
	
	
	/**
	 * 执行类类方法
	 */	
	public void execute();
	
}
