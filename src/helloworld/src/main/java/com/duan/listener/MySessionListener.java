package com.duan.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener{

	
	/*
	 * 会话创建
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
	}       
	

	/*
	 * 会话销毁
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		
	}

}
