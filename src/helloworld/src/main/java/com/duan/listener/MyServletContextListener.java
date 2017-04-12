package com.duan.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.duan.common.tool.SystemUtils;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("****************************应用上下文开始启动了****************************");
		ServletContext context=event.getServletContext();
		
		//加载应用上下文路径
		context.setAttribute("ctx", SystemUtils.getBasePath());
		
	}

}
