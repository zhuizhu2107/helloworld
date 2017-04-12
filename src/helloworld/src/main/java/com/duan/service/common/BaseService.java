package com.duan.service.common;

import java.io.Serializable;

public abstract interface BaseService<T> {
	/**
	 * 添加类方法(保存实体)
	 */
	public Serializable saveEntity(T t);
}
