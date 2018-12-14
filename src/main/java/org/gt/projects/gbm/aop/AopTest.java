package org.gt.projects.gbm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author  JX.Wu
 * @date  2018年12月14日
 */
@Aspect
@Component
public class AopTest {
	
	@Pointcut("execution(* org.gt.projects.gbm.service.impl.*.*(..))")
	public void excu() {
		System.out.println("run excu...");
	}
	
	@Before("excu()")
	public void before() {
		System.out.println("==before==");
	}
	
	@Before("@annotation(TestAnnotation)")
	public void beforeAnnotation() {
		System.out.println("==before annotation==");
	}
	
	@After("excu()")
	public void after() {
		System.out.println("==after==");
	}

	@Around("excu()")
	public void test(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("==模拟开启事务==");
		
		joinPoint.proceed();
		
		System.out.println("==模拟关闭事务==");
	}
	
}

