package com.sc.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.entity.SysUser;
import com.sc.service.SysUserService;

public class CustomRealmMD5 extends AuthorizingRealm{
	
	//����ע��
	@Autowired
	SysUserService sysUserService;

	//�û���Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		/*String username=(String)arg0.getPrimaryPrincipal();
		System.out.println("��Ҫ��Ȩ���û����ǣ�"+username);
		
		//�Ժ�����ݿ��ѯ���û�ӵ�е�Ȩ�ޣ���������
		//������ģ��һЩȨ��
		List<String> allperms=new ArrayList<String>();
		allperms.add("users:add");
		allperms.add("users:delete");
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRole("admin");
		info.addStringPermissions(allperms);
		
		return info;*/
		return null;
	}

	//�û���֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//ͨ��token��ȡ��Ҫ��֤���û�����
		String username=(String)arg0.getPrincipal();
		System.out.println("��Ҫ��֤���û����ǣ�"+username);
		
		//��Ҫͨ���û��������ݿ��ѯ�Ƿ���ڴ��û�
		SysUser sysUser = sysUserService.login(username);
		
		if(sysUser==null){
			System.out.println("�û�������");
			return null;//��������ڣ����ؿ�
		}
		
		//˵�������������û�
		
		//�û������ȡ��Ӧ���������
		String password=sysUser.getPassword();
		String salt=sysUser.getSalt();
		
		//ƥ������
		SimpleAuthenticationInfo info=
				new SimpleAuthenticationInfo(
						sysUser, password,
						ByteSource.Util.bytes(salt),
						this.getName());
		
		return info;
	}

}
