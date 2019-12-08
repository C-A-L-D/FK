package com.sc.aspect;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//��־������(ע�ⷽʽ:������+�е�(�Զ���)+ǰ��֪ͨ+����֪ͨ)--------ȱ�㣺����Java����
@Aspect
public class LogAspect2 {

	//�����ƥ��ִ�У��������η�    ��������      ����.����.������(�����б�)��
	//					com.sc..(..��ʾcom.sc��ǰ�������Ӱ�)   (..)(�����б���)
	@Pointcut("execution(* com.sc..*.*(..))")
	public void pc(){}
	
	//ǰ��֪ͨ				JoinPoint(���ӵ�)
	@Before("pc()")
	public void before(JoinPoint jp){
		System.out.println("[ϵͳ��־]��" + LocalDateTime.now() + "��" + jp.getSignature().getName()
				+ "��ʼִ�У������ǣ�" + Arrays.toString(jp.getArgs()));
	}
	
	@After("pc()")
	public void after(JoinPoint jp){
		System.out.println("[ϵͳ��־]��" + LocalDateTime.now() +"��" + jp.getSignature().getName()
				+ "����ִ�У�");
	}
}
