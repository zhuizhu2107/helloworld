package com.duan.schedule.taskThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.duan.common.tool.ServletUtils;

/**
 *	关于定时处理多余的HttpSession的线程处理类
 */
public class SessionProblem extends Thread {

	@Override
	public synchronized void run() {
		System.out.println("开始处理多余的HttpSession");
		ServletContext servletContext = ServletUtils.getServletContext();
		@SuppressWarnings("unchecked")
		Set<HttpSession> set=(Set<HttpSession>) servletContext.getAttribute("mySessions");
		
		Iterator<HttpSession> it = set.iterator();//先迭代出来  
		List<HttpSession> list=new ArrayList<HttpSession>();//要删除的数据
		
        while(it.hasNext()){//遍历  
        	HttpSession session=it.next(); 
        	if(!ServletUtils.isExitInContext(session)){
        		session.invalidate();
        		list.add(session);
        	}
        } 
        
        for (int i = 0; i <list.size(); i++) {
        	HttpSession session=list.get(i);
        	set.remove(session);
		}
        
        servletContext.setAttribute("mySessions", set);
	}
	
}
