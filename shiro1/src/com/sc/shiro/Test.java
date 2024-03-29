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
		//读取ini初始化配置文件，创建安全管理器工厂
		Factory<SecurityManager> f = new IniSecurityManagerFactory("classpath:shiro.ini");
		//获取安全管理器对象
		SecurityManager sm = f.getInstance();
		//把安全管理器设置到当前环境
		SecurityUtils.setSecurityManager(sm);
		//获取需要认证的主体对象
		Subject sub = SecurityUtils.getSubject();
		//模拟：需要认证的用户令牌对象
		UsernamePasswordToken token = new UsernamePasswordToken("lisi", "456"); 
		try {
			//开始提交登陆的认证
			sub.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(sub.isAuthenticated() ? "通过":"不通过");
		
		//测试是否拥有角色
		System.out.println(sub.hasRole("admin") ? "是管理员":"不是管理员");
		//测试是否拥有权限
		System.out.println(sub.isPermitted("users:add") ? "有添加用户权限":"无添加用户权限");
		
		//再模拟退出登录
		sub.logout();
		//退出后查看是否通过认证
		System.out.println(sub.isAuthenticated() ? "通过":"不通过");
	}

}
