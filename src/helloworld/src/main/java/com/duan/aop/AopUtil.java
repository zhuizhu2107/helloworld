package com.duan.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ddp
 */
@Component
@Aspect
public class AopUtil {
	
	public AopUtil(){
		System.out.println("AopUtil  Test");
	}
	
	/**
	 * aop-start
	 */
	@Before("execution(* com.duan.service*.*(..))")
	public void aopBegin(){
		System.out.println("beginTransaction");
	}
	
	/**
	 * aop-end
	 */
	@After("execution(* com.duan.service*.*(..))")
	public void aopEnd(){
		System.out.println("commitTransaction");
	}
	
}
