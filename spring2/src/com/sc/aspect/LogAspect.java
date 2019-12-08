package com.sc.aspect;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;

//日志切面类
public class LogAspect {

	//前置通知				JoinPoint(连接点)
	public void before(JoinPoint jp){
		System.out.println("[系统日志]：" + LocalDateTime.now() + "：" + jp.getSignature().getName()
				+ "开始执行！参数是：" + Arrays.toString(jp.getArgs()));
	}
	
	public void after(JoinPoint jp){
		System.out.println("[系统日志]：" + LocalDateTime.now() +"：" + jp.getSignature().getName()
				+ "结束执行！");
	}
}
