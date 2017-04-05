package com.duan.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * 如果是“JdbcTemplate”实现存储的话，这个类只能写和和数据库有关的字段，其他的一概不能写
 * @author Administrator
 */
@Entity
@Table(name="TEST_ACCOUNT",schema="citicsutil")
public class Account {
	private Long accCode;// 主键
	private String accName;// 名称
	private String accRemark;// 备注
	private String accState;// 状态
	private Date accCreatTime;// 创建时间
	private Date accLoginTime;// 登陆时间
	private String accType;// 账号类型

	@Id
	@Column(name="ACC_CODE",nullable=false)
	public Long getAccCode() {
		return accCode;
	}

	public void setAccCode(Long accCode) {
		this.accCode = accCode;
	}

	@Column(name="ACC_NAME",length=64)
	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	@Column(name="ACC_REMARK",length=64)
	public String getAccRemark() {
		return accRemark;
	}

	public void setAccRemark(String accRemark) {
		this.accRemark = accRemark;
	}

	@Column(name="ACC_STATE",length=64)
	public String getAccState() {
		return accState;
	}

	public void setAccState(String accState) {
		this.accState = accState;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACC_CREAT_TIME")
	public Date getAccCreatTime() {
		return accCreatTime;
	}

	public void setAccCreatTime(Date accCreatTime) {
		this.accCreatTime = accCreatTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACC_LOGIN_TIME")
	public Date getAccLoginTime() {
		return accLoginTime;
	}

	public void setAccLoginTime(Date accLoginTime) {
		this.accLoginTime = accLoginTime;
	}

	@Column(name="ACC_TYPE",length=64)
	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
