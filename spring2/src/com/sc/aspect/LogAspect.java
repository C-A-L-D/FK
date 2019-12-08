package com.sc.aspect;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;

//��־������
public class LogAspect {

	//ǰ��֪ͨ				JoinPoint(���ӵ�)
	public void before(JoinPoint jp){
		System.out.println("[ϵͳ��־]��" + LocalDateTime.now() + "��" + jp.getSignature().getName()
				+ "��ʼִ�У������ǣ�" + Arrays.toString(jp.getArgs()));
	}
	
	public void after(JoinPoint jp){
		System.out.println("[ϵͳ��־]��" + LocalDateTime.now() +"��" + jp.getSignature().getName()
				+ "����ִ�У�");
	}
}
