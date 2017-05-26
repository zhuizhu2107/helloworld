package com.duan.common.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* TestSysConfig 实体类(系统配置表)
* Fri May 19 14:16:47 CST 2017
* @author ddp
*/ @Entity
@Table(name="TEST_SYS_CONFIG",schema="citicsutil")
public class SysConfig implements Serializable{
	private static final long serialVersionUID = 1495174607926L;
	/**键**/
	private String configKey;

	/**值**/
	private String configVal;

	/**描述**/
	private String configDesc;

	@Id	@Column(name="CONFIG_KEY",nullable=false,length=32)
	public String getConfigKey() {
	    return configKey;
	}
	public void setConfigKey(String configKey) {
	    this.configKey=configKey;
	}

	@Column(name="CONFIG_VAL",length=256)
	public String getConfigVal() {
	    return configVal;
	}
	public void setConfigVal(String configVal) {
	    this.configVal=configVal;
	}

	@Column(name="CONFIG_DESC",length=512)
	public String getConfigDesc() {
	    return configDesc;
	}
	public void setConfigDesc(String configDesc) {
	    this.configDesc=configDesc;
	}

}
