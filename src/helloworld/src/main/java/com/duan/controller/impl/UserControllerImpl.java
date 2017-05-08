package com.duan.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.duan.bean.User;
import com.duan.common.tool.ServletUtils;
import com.duan.common.tool.ThreadUtils;
import com.duan.controller.UserController;
import com.duan.service.UserService;

@Controller("userController")
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController{

	private Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@Override
	public String login(HttpServletRequest request,HttpServletResponse response,User user,RedirectAttributes redirectAttributes) {
		/**用户信息校验**/
		String sqlWhere="and USER_NAME=? and PASSWORD=? ";
		Object[] values=new Object[]{user.getUserName(),user.getPassword()};
		Type[] types=new Type[]{new StringType(),new StringType()};
		User user_db=userService.getEntityBySqlWhere("TEST_SYS_USER", sqlWhere,values,types);
		
		if(user_db==null){
			redirectAttributes.addFlashAttribute("callJavaScript", ServletUtils.callJavaScript(request.getSession(),"failed", "用户名或密码错误，请核对后登陆","info", "登陆提示"));
			return "redirect:/";
		}
		
		//控制台日志信息
		logger.info("用户"+user.getUserName()+"登陆");
		//入库日志信息
		ThreadUtils.loginLogThread(user_db, this.getClass().getName(),
				"public String login(HttpServletRequest request,HttpServletResponse response,User user)", "info",
				"用户" + user.getUserName() + "登陆成功！！！");
		
		/**用户登陆数量统计**/
		ServletUtils.setUserOnlinesMap(user.getUserName(), request.getSession());
		
		return "redirect:/index.jsp";
		
	}
}
