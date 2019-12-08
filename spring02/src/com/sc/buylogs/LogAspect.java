package com.sc.buylogs;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sc.service.money.TailMoney;

@Aspect
public class LogAspect {
	
	@Pointcut("execution(* com.sc.service.impl.*.*(..))")
	public void pc() {}
	
	@Before("pc()")
	public void before(JoinPoint jp) {
		double m = (double) jp.getArgs()[3] - (double)jp.getArgs()[2];
		if (m <= 0) {
			System.out.println("[��ǰ��־]��" + LocalDateTime.now() + "\n ��" + jp.getArgs()[3] + "\n���㣬���ֵ��");
			throw new RuntimeException("����........................");
		}
		System.out.println("[��ǰ��־]��" + LocalDateTime.now() + "\n ��" + jp.getArgs()[3]);
		System.out.println("-----------------------------------------------------");
	}
	
	@AfterReturning(pointcut="pc()", returning="rev")
	public void after(Object rev) {
		System.out.println("-----------------------------------------------------");
		System.out.println("[������־]��" + LocalDateTime.now() + "\n ��" + rev);
	}
}
