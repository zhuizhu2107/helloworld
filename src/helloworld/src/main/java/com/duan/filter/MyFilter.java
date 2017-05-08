package com.duan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duan.common.tool.ServletUtils;

public class MyFilter implements Filter{
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
        HttpServletRequest req = (HttpServletRequest) request;  
        HttpServletResponse resp = (HttpServletResponse) response;  
        String path = req.getContextPath();  
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";  
        HttpSession session = req.getSession();  
        
        String url=req.getRequestURL().toString();
        
        /**如果不在内存管理中**/
        if(IsSendRedirect(session,url,basePath)){
        	resp.setHeader("Cache-Control", "no-store");  
            resp.setDateHeader("Expires", 0);  
            resp.setHeader("Prama", "no-cache");
            resp.sendRedirect(basePath+"login.jsp?isSendRedirect=true"); 
        }else{
        	chain.doFilter(req, resp); 
        }
        
		//chain.doFilter(request, response);
	}

	private boolean IsSendRedirect(HttpSession session, String url, String basePath) {
		/**只处理两类路径，*.do,*.jsp **/
		if(url.toLowerCase().endsWith(".do")||url.toLowerCase().endsWith(".jsp")){
			String[] nonIntercept = { basePath, basePath + "login.jsp", basePath + "user/login.do",
												  basePath + "pages/user/register.jsp" };
			
			for (int i = 0; i < nonIntercept.length; i++) {
				if(nonIntercept[i].equals(url)){
					return false;
				}
			}

			if(ServletUtils.isExitInContext(session)){
				return false;
			}
			
			return true;
		}
		
		
		return false;
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
