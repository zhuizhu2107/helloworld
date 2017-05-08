package com.duan.common.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 系统日志存储实体
 */
@Entity
@Table(name="TEST_SYS_LOG",schema="citicsutil")
public class SysLog {
	/**主键**/
	private String id;
	
	/**用户ID**/
	private String userCode;
	
	/**用户姓名**/
	private String userName;
	
	/**类名**/
	private String className;
	
	/**方法名**/
	private String mothodName;
	
	/**产生时间**/
	private Date createTime;
	
	/**日志级别**/
	private String logLevel;
	
	/**日志信息**/
	private String logMsg;

	@Id
	@Column(name="ID",nullable=false,length=64)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="USER_CODE",length=128)
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name="USER_NAME",length=256)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="CLASS_NAME",length=128)
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name="MOTHOD_NAME",length=256)
	public String getMothodName() {
		return mothodName;
	}

	public void setMothodName(String mothodName) {
		this.mothodName = mothodName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="LOG_LEVEL",length=32)
	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	@Column(name="LOG_MSG",length=1024)
	public String getLogMsg() {
		return logMsg;
	}

	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	
}
