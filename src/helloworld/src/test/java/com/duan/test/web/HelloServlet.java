package com.duan.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.duan.test.service.HelloWorld;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name="HelloServlet",urlPatterns={"/hello.action"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HelloWorld helloWorld;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用webapplicationcontextutils这个工具类可以很方便的获取ApplicationContext,只需要传入servletContext
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        
        helloWorld = applicationContext.getBean(HelloWorld.class);
        String sayHi = helloWorld.sayHi();
        System.err.println("sayHi:" + sayHi);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h2>" + sayHi + "</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
