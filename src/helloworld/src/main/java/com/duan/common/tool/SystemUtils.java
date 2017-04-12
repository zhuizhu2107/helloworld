package com.duan.common.tool;

import java.io.IOException;
import java.util.Properties;

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
	
	public static void main(String[] args) {
		//System.out.println(getBasePath());
	}
	
}
