package com.duan.common.tool;

import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duan.bean.User;
import com.duan.common.bean.SysLog;

/**
 * 日志工具类
 * @author 段大平
 *2017年4月7日 18:55:46
 */
public class LogUitls implements Runnable{
	private static final String POINT="LogUitls";
	
	/**用户信息**/
	private User user;
	
	/**类名信息**/
	private String className;
	
	/**方法信息**/
	private String mothodName;
	
	/**日志级别信息**/
	private String logLevel;
	
	/**日志信息**/
	private String logMsg;
	
	/**默认构造方法**/
	public LogUitls(){}
	
	/**带参数构造方法**/
	public LogUitls(User user, String className, String mothodName, String logLevel, String logMsg) {
		this.user = user;
		this.className = className;
		this.mothodName = mothodName;
		this.logLevel = logLevel;
		this.logMsg = logMsg;
	}

	/**
	 * 插入日志
	 */
	@Override
	public void run() {
		SysLog sysLog=new SysLog();
		synchronized (POINT) {
			Session session=DBUtils.openSession();
			Transaction transaction=session.beginTransaction();
			sysLog.setId(UUID.randomUUID().toString());
			sysLog.setUserCode(user.getUserId());
			sysLog.setUserName(user.getUserName());
			sysLog.setClassName(className);
			sysLog.setMothodName(mothodName);
			sysLog.setCreateTime(new Date());
			sysLog.setLogLevel(logLevel);
			sysLog.setLogMsg(logMsg);
			session.save(sysLog);
			transaction.commit();
			session.close();
		}
	}
	
}
