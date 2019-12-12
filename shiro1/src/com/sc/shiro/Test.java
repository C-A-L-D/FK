package com.sc.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ȡini��ʼ�������ļ���������ȫ����������
		Factory<SecurityManager> f = new IniSecurityManagerFactory("classpath:shiro.ini");
		//��ȡ��ȫ����������
		SecurityManager sm = f.getInstance();
		//�Ѱ�ȫ���������õ���ǰ����
		SecurityUtils.setSecurityManager(sm);
		//��ȡ��Ҫ��֤���������
		Subject sub = SecurityUtils.getSubject();
		//ģ�⣺��Ҫ��֤���û����ƶ���
		UsernamePasswordToken token = new UsernamePasswordToken("lisi", "456"); 
		try {
			//��ʼ�ύ��½����֤
			sub.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(sub.isAuthenticated() ? "ͨ��":"��ͨ��");
		
		//�����Ƿ�ӵ�н�ɫ
		System.out.println(sub.hasRole("admin") ? "�ǹ���Ա":"���ǹ���Ա");
		//�����Ƿ�ӵ��Ȩ��
		System.out.println(sub.isPermitted("users:add") ? "������û�Ȩ��":"������û�Ȩ��");
		
		//��ģ���˳���¼
		sub.logout();
		//�˳���鿴�Ƿ�ͨ����֤
		System.out.println(sub.isAuthenticated() ? "ͨ��":"��ͨ��");
	}

}
