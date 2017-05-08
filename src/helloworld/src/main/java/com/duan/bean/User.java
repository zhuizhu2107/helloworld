package com.duan.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 如果是“JdbcTemplate”实现存储的话，这个类只能写和和数据库有关的字段，其他的一概不能写
 * @author 段大平
 */
@Entity
@Table(name="TEST_SYS_USER",schema="citicsutil")
public class User implements Serializable{
	private static final long serialVersionUID = 1492675505353L;
	/**用户编码**/
	private String userId;

	/**用户名称，登陆标识**/
	private String userName;

	/**用户密码，登陆标识**/
	private String password;

	/**用户昵称**/
	private String nickName;

	/**用户真实姓名**/
	private String realName;

	/**创建时间**/
	private Date createTime;

	/**创建人**/
	private String createBy;

	/**维护时间**/
	private Date updateTime;

	/**维护人**/
	private String updateBy;

	@Id
	@Column(name="USER_ID",nullable=false,length=32)
	public String getUserId() {
	    return userId;
	}
	public void setUserId(String userId) {
	    this.userId=userId;
	}

	@Column(name="USER_NAME",length=64)
	public String getUserName() {
	    return userName;
	}
	public void setUserName(String userName) {
	    this.userName=userName;
	}

	@Column(name="PASSWORD",length=32)
	public String getPassword() {
	    return password;
	}
	public void setPassword(String password) {
	    this.password=password;
	}

	@Column(name="NICK_NAME",length=128)
	public String getNickName() {
	    return nickName;
	}
	public void setNickName(String nickName) {
	    this.nickName=nickName;
	}

	@Column(name="REAL_NAME",length=128)
	public String getRealName() {
	    return realName;
	}
	public void setRealName(String realName) {
	    this.realName=realName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
	    return createTime;
	}
	public void setCreateTime(Date createTime) {
	    this.createTime=createTime;
	}

	@Column(name="CREATE_BY",length=32)
	public String getCreateBy() {
	    return createBy;
	}
	public void setCreateBy(String createBy) {
	    this.createBy=createBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_TIME")
	public Date getUpdateTime() {
	    return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
	    this.updateTime=updateTime;
	}

	@Column(name="UPDATE_BY",length=32)
	public String getUpdateBy() {
	    return updateBy;
	}
	public void setUpdateBy(String updateBy) {
	    this.updateBy=updateBy;
	}

}