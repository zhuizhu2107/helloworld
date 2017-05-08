package com.duan.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.duan.common.tool.ServletUtils;

public class MySessionListener implements HttpSessionListener{

	
	/*
	 * 会话创建
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		/**放入session到应用上下文中**/
		ServletContext context=event.getSession().getServletContext();
		HttpSession session=event.getSession();
		
		@SuppressWarnings("unchecked")
		Set<HttpSession> set=(Set<HttpSession>) context.getAttribute("mySessions");
		if(set==null){
			set=new HashSet<HttpSession>();
		}
		
		//放置信息
		set.add(session);
		
		context.setAttribute("mySessions", set);
	}       
	

	/*
	 * 会话销毁
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		/**把session从应用上下文中移除**/
		HttpSession session=event.getSession();
		ServletUtils.removeUserOnlinesMap(session);
	}

}
