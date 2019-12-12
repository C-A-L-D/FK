package com.sc.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomRealmMD5 extends AuthorizingRealm {

	/*
	 * �û���Ȩ����
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		String username = (String)arg0.getPrimaryPrincipal();
		System.out.println("��Ҫ��Ȩ���û����ǣ�" + username);
		
		//�Ժ�����ݿ��ѯ���û���Ȩ�ޣ���������
		//����ֻģ��
		List<String> allperms = new ArrayList<String>();
		allperms.add("users:add");
		allperms.add("users:delete");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("admin");
		info.addStringPermissions(allperms);
		System.out.println(info.toString());
		return info;
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
		String password = "d795d5105df924618a10253012b79fc2";
		String salt = "qwerty";

		//��ȡ�û����������ݿ�����򷵻��û���
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), this.getName());
		
		return info;
	}

}
