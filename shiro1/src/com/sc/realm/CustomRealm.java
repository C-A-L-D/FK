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
	 * 用户授权方法
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 用户认证方法
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		//通过token获取需要认证的用户名
		String username = (String)arg0.getPrincipal();
		System.out.println("需要认证的用户名：" + username);
		
		//以后需要通过用户名到数据库查询是否存在此用户
		//今天先模拟用户信息，直接在此写死用户信息
		if (!username.equals("zhangsan") && !username.equals("lisi")) {
			return null;//如果不存在，返回空
		}
		
		//说明存在这样的用户
		//模拟一个固定的密码，以后从数据库查出密码
		String password = "123";
		
		
		//匹配密码
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());
		System.out.println("认证返回信息：" + info);
		return info;
	}

}
