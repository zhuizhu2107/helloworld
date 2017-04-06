package com.duan.aop;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;

/**
 * @author ddp
 */
public class AopUtil {
	
	public AopUtil(){
		System.out.println("AopUtil  Test");
	}
	
	/**
	 * aop-start
	 */
	public void aopBegin(JoinPoint joinPoint){
		System.out.println("beginTransaction");
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
	}
	
	/**
	 * aop-end
	 */
	public void aopEnd(JoinPoint joinPoint){
		System.out.println("commitTransaction");
	}
	
}
