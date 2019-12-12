package com.sc.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {

	/*
	 * �û���Ȩ����
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * �û���֤����
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		//ͨ��token��ȡ��Ҫ��֤���û���
		String username = (String)arg0.getPrincipal();
		System.out.println("��Ҫ��֤���û�����" + username);
		
		//�Ժ���Ҫͨ���û��������ݿ��ѯ�Ƿ���ڴ��û�
		//������ģ���û���Ϣ��ֱ���ڴ�д���û���Ϣ
		if (!username.equals("zhangsan") && !username.equals("lisi")) {
			return null;//��������ڣ����ؿ�
		}
		
		//˵�������������û�
		//ģ��һ���̶������룬�Ժ�����ݿ�������
		String password = "123";
		
		
		//ƥ������
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());
		System.out.println("��֤������Ϣ��" + info);
		return info;
	}

}
