package com.duan.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonController {
	/**
	 * 删除session中的指定键值
	 * @param key 键值
	 */
	public void removeSessionKey(HttpServletRequest request,HttpServletResponse response,String key);
	
}
