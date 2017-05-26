package com.duan.common.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.duan.bean.User;

/**
 * @author ddp ServletUtils 工具类
 */
public class ServletUtils {


	/**
	 * 用户人数集合维护
	 * @param loginName 登陆名 唯一
	 * @param sessionId  
	 */
	public static boolean setUserOnlinesMap(String loginName,HttpSession session){
		ServletContext servletContext=getServletContext();
		@SuppressWarnings("unchecked")
		Map<String,HttpSession> map=(Map<String,HttpSession>) servletContext.getAttribute("userOnlines");
		
		if(map!=null&&map.get(loginName)!=null){
			/**获取到了登陆信息**/
			HttpSession old_session=map.get(loginName);
			
			/**如果两个session不相同的情况下进行操作，减小内存开支**/
			if(!(old_session==session)){
				//注销old_session对象信息
				old_session.invalidate();
				
				//重新加载
				map.put(loginName, session);
				
			}
			
		}else{
			/**没有登陆信息**/
			map=new HashMap<String,HttpSession>();
			map.put(loginName, session);
		}
		
		//重新赋值
		servletContext.setAttribute("userOnlines", map);
		
		return true;
	}
	
	/**
	 * HttpSession 是否在内存用户管理中
	 */
	public static boolean isExitInContext(HttpSession session){
		ServletContext servletContext = getServletContext();
		@SuppressWarnings("unchecked")
		Map<String,HttpSession> map=(Map<String,HttpSession>) servletContext.getAttribute("userOnlines");
		if(map!=null){
			for (String key : map.keySet()) {
				if(map.get(key)==session){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 *  移除在内存用户管理中（“mySessions”）的指定HttpSession
	 *  同时执行多个移除操作的话要一个一个的进行，保证每一个都是独立执行完成的
	 */
	public synchronized static void removerUserOfMySessions(HttpSession session) {
		ServletContext servletContext=getServletContext();
		@SuppressWarnings("unchecked")
		Set<HttpSession> set=(Set<HttpSession>) servletContext.getAttribute("mySessions");
		if(set!=null){
			Iterator<HttpSession> it = set.iterator();//先迭代出来  
			List<HttpSession> list=new ArrayList<HttpSession>();//要删除的数据
			
	        while(it.hasNext()){//遍历  
	        	HttpSession currentSession=it.next(); 
	        	if(currentSession==session){
	        		list.add(currentSession);
	        	}
	        }
	        
	        for (int i = 0; i < list.size(); i++) {
	        	set.remove(session);
			}
		}else{
			set=new HashSet<HttpSession>();
		}
		
		//重新加载
		servletContext.setAttribute("mySessions", set);
		
	}
	
	
	/**
	 *  移除在内存用户管理中（“userOnlines”）的指定HttpSession
	 *  同时执行多个移除操作的话要一个一个的进行，保证每一个都是独立执行完成的
	 */
	public synchronized static void removeUserOnlinesMap(HttpSession session){
		ServletContext servletContext=getServletContext();
		@SuppressWarnings("unchecked")
		Map<String,HttpSession> map=(Map<String,HttpSession>) servletContext.getAttribute("userOnlines");
		if(map!=null){
			for (String key : map.keySet()) {
				if(map.get(key)==session){
					map.remove(key);
				}
			}
		}else{
			map=new HashMap<String,HttpSession>();
		}
		
		//重新加载
		servletContext.setAttribute("userOnlines",map);
	}
	
	/**
	 * 获取在线人数
	 * @return
	 */
	public static int getUserOnlines(){
		Map<String,HttpSession> map=getUserOnlinesMap();
		return map.size();
	}
	
	/**
	 * 获取在线人数的集合
	 * @return
	 */
	public static Map<String,HttpSession> getUserOnlinesMap() {
		ServletContext servletContext = getServletContext();
		@SuppressWarnings("unchecked")
		Map<String,HttpSession> map=(Map<String,HttpSession>) servletContext.getAttribute("userOnlines");
		return map;
	}

	/**
	 * 获取ServletContext上下文对象
	 * @return
	 */
	public static ServletContext getServletContext() {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		return servletContext;
	}

	
	/**
	 * 获取HttpSession
	 */
	public static HttpSession getHttpSession(HttpServletRequest request) {
		ServletContext servletContext = getServletContext();
		HttpSession session = (HttpSession) servletContext.getAttribute("mySession");
		if (session == null) {
			session = request.getSession();
		}
		return session;
	}

	/**
	 * 通过HttpServletRequest返回IP地址
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ip String
	 * @throws Exception
	 */
	public static String getIpAddr(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	
	/**
	 * 返回js的拼串 function callback4Page(flag,content,type,tile){
	 * @param tile
	 * @param content
	 * @return
	 */
	public static String callJavaScript(HttpSession session,String flag,String content,String type,String tile){
		//清除缓存中的callJavaScript对应的数据
		session.removeAttribute("callJavaScript");
		String callJavaScript="callback4Page('"+flag+"','"+content+"','"+type+"','"+tile+"');";
		return callJavaScript;
	}
	
	/***
	 * 获取当前的用户对象信息
	 */
	public static User getCurrentUser(HttpSession session){
		User user=(User) session.getAttribute("currentUser");
		return user;
	}
	
}
