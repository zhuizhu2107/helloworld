package com.duan.common.tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 数据库工具
 * @author 段大平
 *2017年4月7日 18:57:10
 */
public class DBUtils {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void setSessionFactory(SessionFactory sessionFactory) {
		DBUtils.sessionFactory = sessionFactory;
	}

	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
