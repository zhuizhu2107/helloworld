package com.duan.common.tool;

import com.duan.bean.User;

/**
 *线程工具类，启动各种任务
 *用于多线程编程使用
 */
public class ThreadUtils {

	/**
	 * 登陆日志存储线程
	 */
	public static void loginLogThread(User user,String className,String mothodName,String logLevel,String logMsg){
		LogUitls logUitls=new LogUitls(user, className,mothodName,logLevel,logMsg);
		Thread thread=new Thread(logUitls);
		thread.start();
	}
	
}