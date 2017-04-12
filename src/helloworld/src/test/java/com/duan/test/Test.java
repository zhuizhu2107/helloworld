package com.duan.test;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 测试类
 * @author Administrator
 */
public class Test {
	
	@org.junit.Test
	public void run20170407() {
		String id=UUID.randomUUID().toString();
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
