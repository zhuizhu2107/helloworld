package com.duan.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class DbTest {

	@Test
	public void testDbConn(){
	    Connection con = null;// 创建一个数据库连接
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    ResultSet result = null;// 创建一个结果集对象
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");//加载驱动类
			 String url="jdbc:oracle:thin:@172.22.144.210:1521:EOSP";//数据库为school
	         String user="citicsutil";//用户名system
	         String password="citicsutil";//登录密码
	         con=DriverManager.getConnection(url,user,password);
	         String sql = "select 1 from dual where 1=?";// 预编译语句，“？”代表参数
	         pre = con.prepareStatement(sql);// 实例化预编译语句
	         pre.setInt(1, 1);
	         result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	         while (result.next()){
	        	// 当结果集不为空时
	        	 System.out.println("成功获取结果："+result.getInt(1));
	         }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
