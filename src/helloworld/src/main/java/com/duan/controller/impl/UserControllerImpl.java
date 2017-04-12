package com.duan.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duan.bean.User;
import com.duan.controller.UserController;
import com.duan.service.UserService;

@Controller("userController")
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Override
	public String login(HttpServletRequest request,HttpServletResponse response,User user) {
		/**用户信息校验**/
		String sqlWhere="and USER_NAME=? and PASSWORD=? ";
		Object[] values=new Object[]{user.getUserName(),user.getPassword()};
		Type[] types=new Type[]{new StringType(),new StringType()};
		User user_db=userService.getEntityBySqlWhere("TEST_SYS_USER", sqlWhere,values,types);
		
		if(user_db==null){
			return null;
		}
		
		
		return "index";
	}

}
