package com.duan.controller.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.duan.bean.User;
import com.duan.common.bean.SysConfig;
import com.duan.common.tool.ServletUtils;
import com.duan.common.tool.StringUtils;
import com.duan.common.tool.SystemUtils;
import com.duan.common.tool.ThreadUtils;
import com.duan.controller.UserController;
import com.duan.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		HttpSession session=request.getSession();
		session.setAttribute("currentUser", user);
		ServletUtils.setUserOnlinesMap(user.getUserName(),session);
		
		/**获取数据库配置信息**/
		SysConfig config=SystemUtils.getSysConfig("indexPage");
		
		return "redirect:"+config.getConfigVal();
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public synchronized Map<String, Object> register(HttpServletRequest request, HttpServletResponse response, User user,RedirectAttributes redirectAttributes) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		//控制台日志信息
		logger.info("用户"+user.getUserName()+"注册信息填写");
		
		/**数据处理加工过程**/
		Date date=new Date();
		String userId=StringUtils.getUUIDStr();
		user.setUserId(userId);//用户编码
		user.setCreateTime(date);
		user.setCreateBy(userId);
		
		//存储数据
		Serializable id=userService.saveEntity(user);
		if(id!=null&&!"".equals(id)){
			map.put("flag", "success"); 
			
			//入库日志信息
			ThreadUtils.loginLogThread(user, this.getClass().getName(),
					"public Map<String, Object> register(HttpServletRequest request, HttpServletResponse response, User user,RedirectAttributes redirectAttributes)", "info",
					"用户" + user.getUserName() + "注册成功！！！");				
		}else{
			map.put("flag", "fail"); 
		}

		return map;
	}

	@RequestMapping(value = "/checkUserNameExists", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public String checkUserNameExists(String userName) {
		boolean result = true;
		Map<String, Boolean> map = new HashMap<>();
        
		if(StringUtils.isNotEmpty(userName)){
			User user=userService.getEntityBySqlProperty("TEST_SYS_USER", "USER_NAME", userName);
			if(user!=null){
				result=false;
			}
		}
		
		map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
		
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
	}
	
}
