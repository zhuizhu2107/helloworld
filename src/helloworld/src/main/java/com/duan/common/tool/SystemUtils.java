package com.duan.common.tool;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;

import com.duan.common.bean.SysConfig;

/**
 * 系统工具类
 * @author 段大平
 *2017年4月10日
 */
public class SystemUtils {
	static Properties prop=null;
	
	static{
		prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("init.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取项目根路径
	 */
	public static String getBasePath(){
		return prop.getProperty("bathPath");
	} 
	
	//////////////////////////////////////////////////配置获取路径分割线，以上是文件配置，以下是数据库配置//////////////////////////////////////////////////////////
	/**
	 * 获取数据库中的键值对配置信息实体
	 * @param key 键
	 * @return
	 */
	public static SysConfig getSysConfig(String key){
		Session session=DBUtils.openSession();
		
		//获取实体
		SysConfig config=(SysConfig)session.get(SysConfig.class, key);
		
		session.close();
		
		return config;
	}
	
	public static void main(String[] args) {
		//System.out.println(getBasePath());
	}
	
}
