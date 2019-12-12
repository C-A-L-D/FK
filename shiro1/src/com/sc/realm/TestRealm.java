package com.sc.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestRealm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ȡini��ʼ�������ļ���������ȫ����������
		Factory<SecurityManager> f = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		//��ȡ��ȫ����������
		SecurityManager sm = f.getInstance();
		//�Ѱ�ȫ���������õ���ǰ����
		SecurityUtils.setSecurityManager(sm);
		//��ȡ��Ҫ��֤���������
		Subject sub = SecurityUtils.getSubject();
		//ģ�⣺��Ҫ��֤���û����ƶ���
		UsernamePasswordToken token = new UsernamePasswordToken("lisi", "123"); 
		try {
			//��ʼ�ύ��½����֤---------------����һ�����߳�������֤��Ȩ��
			sub.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(sub.isAuthenticated() ? "ͨ��":"��ͨ��");
		//��ģ���˳���¼
		sub.logout();
		//�˳���鿴�Ƿ�ͨ����֤
		System.out.println(sub.isAuthenticated() ? "ͨ��":"��ͨ��");
	}

}
