package com.duan.test.service;

import java.util.Date;

public class HelloWorldImpl implements HelloWorld {

	private String msg;
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String sayHi() {
        return "当前时间:"+new Date()+" msg:"+msg;
    }
    
}
