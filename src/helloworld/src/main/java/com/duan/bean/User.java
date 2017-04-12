package com.duan.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 如果是“JdbcTemplate”实现存储的话，这个类只能写和和数据库有关的字段，其他的一概不能写
 * @author 段大平
 */
@Entity
@Table(name="TEST_SYS_USER",schema="citicsutil")
public class User {

	private String userId;
	private String userName;//用户名
	private String password;//用户密码
	
	@Id
	@Column(name="USER_ID",nullable=false,length=32)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="USER_NAME",length=64)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="PASSWORD",length=32)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
