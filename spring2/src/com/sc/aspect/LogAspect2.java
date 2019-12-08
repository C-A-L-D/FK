package com.sc.aspect;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//日志切面类(注解方式:切面类+切点(自定义)+前置通知+后置通知)--------缺点：入侵Java代码
@Aspect
public class LogAspect2 {

	//切入点匹配执行（访问修饰符    返回类型      包名.类名.方法名(参数列表)）
	//					com.sc..(..表示com.sc当前包及其子包)   (..)(参数列表不限)
	@Pointcut("execution(* com.sc..*.*(..))")
	public void pc(){}
	
	//前置通知				JoinPoint(连接点)
	@Before("pc()")
	public void before(JoinPoint jp){
		System.out.println("[系统日志]：" + LocalDateTime.now() + "：" + jp.getSignature().getName()
				+ "开始执行！参数是：" + Arrays.toString(jp.getArgs()));
	}
	
	@After("pc()")
	public void after(JoinPoint jp){
		System.out.println("[系统日志]：" + LocalDateTime.now() +"：" + jp.getSignature().getName()
				+ "结束执行！");
	}
}
