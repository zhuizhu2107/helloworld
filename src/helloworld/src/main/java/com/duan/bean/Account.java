package com.duan.bean;

import java.util.Date;

/**
 * 如果是“JdbcTemplate”实现存储的话，这个类只能写和和数据库有关的字段，其他的一概不能写
 * @author Administrator
 */
public class Account {
	private Long accCode;// 主键
	private String accName;// 名称
	private String accRemark;// 备注
	private String accState;// 状态
	private Date accCreatTime;// 创建时间
	private Date accLoginTime;// 登陆时间
	private String accType;// 账号类型

	public Long getAccCode() {
		return accCode;
	}

	public void setAccCode(Long accCode) {
		this.accCode = accCode;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccRemark() {
		return accRemark;
	}

	public void setAccRemark(String accRemark) {
		this.accRemark = accRemark;
	}

	public String getAccState() {
		return accState;
	}

	public void setAccState(String accState) {
		this.accState = accState;
	}

	public Date getAccCreatTime() {
		return accCreatTime;
	}

	public void setAccCreatTime(Date accCreatTime) {
		this.accCreatTime = accCreatTime;
	}

	public Date getAccLoginTime() {
		return accLoginTime;
	}

	public void setAccLoginTime(Date accLoginTime) {
		this.accLoginTime = accLoginTime;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
