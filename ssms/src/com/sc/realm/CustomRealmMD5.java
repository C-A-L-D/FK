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
	
	//依赖注入
	@Autowired
	SysUserService sysUserService;

	//用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		/*String username=(String)arg0.getPrimaryPrincipal();
		System.out.println("需要授权的用户名是："+username);
		
		//以后从数据库查询该用户拥有的权限，保存起来
		//今天先模拟一些权限
		List<String> allperms=new ArrayList<String>();
		allperms.add("users:add");
		allperms.add("users:delete");
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRole("admin");
		info.addStringPermissions(allperms);
		
		return info;*/
		return null;
	}

	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//通过token获取需要认证的用户名称
		String username=(String)arg0.getPrincipal();
		System.out.println("需要认证的用户名是："+username);
		
		//需要通过用户名到数据库查询是否存在此用户
		SysUser sysUser = sysUserService.login(username);
		
		if(sysUser==null){
			System.out.println("用户不存在");
			return null;//如果不存在，返回空
		}
		
		//说明存在这样的用户
		
		//用户对象获取对应的密码和盐
		String password=sysUser.getPassword();
		String salt=sysUser.getSalt();
		
		//匹配密码
		SimpleAuthenticationInfo info=
				new SimpleAuthenticationInfo(
						sysUser, password,
						ByteSource.Util.bytes(salt),
						this.getName());
		
		return info;
	}

}
