package com.sc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.Users;

@Controller  //控制器注解，注册bean对象，默认对象名是类名首字母小写
@RequestMapping("/loginctrl") //类的请求映射url
public class LoginController {
	
	@RequestMapping("/login.do") //方法的请求映射url
	//完整的地址是：http://localhost:8080/springmvc01/loginctrl/login.do
	public ModelAndView login(ModelAndView mav,
			Users user,HttpSession session){//把请求参数值自动封装到对象的属性
		System.out.println("开始登录……");
		System.out.println("用户对象信息："+user);
		
        //模拟登录		
		if(user.getUname().equals("admin")&&
				user.getUpass().equals("123")){
			//登录成功
			session.setAttribute("nowuser", user);//用户对象存入session
			mav.setViewName("redirect:../main.jsp");//重定向到主界面
		}else{
			//登录失败
			mav.setViewName("redirect:../login.jsp?isfail=yes");//设置视图名称，重定向到login.jsp
		}
		
		return mav;
	}

}
