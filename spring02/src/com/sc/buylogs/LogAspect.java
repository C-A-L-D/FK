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
			System.out.println("[购前日志]：" + LocalDateTime.now() + "\n 余额：" + jp.getArgs()[3] + "\n余额不足，请充值！");
			throw new RuntimeException("余额不足........................");
		}
		System.out.println("[购前日志]：" + LocalDateTime.now() + "\n 余额：" + jp.getArgs()[3]);
		System.out.println("-----------------------------------------------------");
	}
	
	@AfterReturning(pointcut="pc()", returning="rev")
	public void after(Object rev) {
		System.out.println("-----------------------------------------------------");
		System.out.println("[购后日志]：" + LocalDateTime.now() + "\n 余额：" + rev);
	}
}
