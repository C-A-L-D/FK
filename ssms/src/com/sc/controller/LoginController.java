package com.sc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.SysUser;
import com.sc.entity.Users;
import com.sc.service.UsersService;

@Controller  //控制器注解，注册bean对象，默认对象名是类名首字母小写
@RequestMapping("/loginctrl") //类的请求映射url
public class LoginController {
	
	@Autowired
	UsersService usersService;//依赖service
	
	//认证失败的方法
	@RequestMapping("/login.do") 
	public ModelAndView login(ModelAndView mav,
			HttpServletRequest req){
		System.out.println("用户认证失败！");
		
		String msg=(String)req.getAttribute(
			FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		System.out.println("认证失败信息是："+msg);
		
		String fail="";
		if(msg!=null){
			if(msg.equals(UnknownAccountException.class.getName())){
				fail="unknown";//用户名不存在
			}else if(msg.equals(IncorrectCredentialsException.class.getName())){
				fail="error";//密码错误
			}else if(msg.equals("randomCodeError")){
				fail="code";//验证码错误
			}else{
				fail="other";//未知错误
			}
		}
		
		mav.setViewName("redirect:../login.jsp?isfail="+fail);//设置视图名称，重定向到login.jsp
		
		return mav;
	}
	
	//认证成功的方法
	@RequestMapping("/main.do") 
	public ModelAndView main(ModelAndView mav,
			HttpSession session){
		System.out.println("用户认证成功");
		
		//获取主体
		Subject subject = SecurityUtils.getSubject();
		//获取通过认证的用户对象
		SysUser sysUser=(SysUser)subject.getPrincipal();
		session.setAttribute("nowuser", sysUser);
		
		mav.setViewName("redirect:../main.jsp");
		return mav;
	}

}
