package com.duan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.duan.common.tool.StringUtils;

/**
 * 测试类
 * @author Administrator
 */
public class Test {
	
	
	@org.junit.Test
	public void run20170503() {
		
	}
	
	@org.junit.Test
	public void run20170407() {
		String id=StringUtils.getUUIDStr();
		System.out.println(id);
		System.out.println(id.length());
	}
	
	@org.junit.Test
	public void test(){
		Configuration config = new Configuration().configure("/hibernate.db.cfg.xml");
        //创建sessionFactory对象  
        @SuppressWarnings("deprecation")
		SessionFactory sf = config.buildSessionFactory();  
        //打开session，操作数据库  
        Session session = sf.openSession();
        //开启事务  
        Transaction tr = session.beginTransaction();  
        
        System.out.println(session+"保存成功");
        
        //提交事务  
        tr.commit();  
        session.close();  
	}
	
}
