package com.duan.service.impl;

import org.springframework.stereotype.Service;

import com.duan.bean.User;
import com.duan.service.UserService;
import com.duan.service.common.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
}
