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

@Controller  //������ע�⣬ע��bean����Ĭ�϶���������������ĸСд
@RequestMapping("/loginctrl") //�������ӳ��url
public class LoginController {
	
	@Autowired
	UsersService usersService;//����service
	
	//��֤ʧ�ܵķ���
	@RequestMapping("/login.do") 
	public ModelAndView login(ModelAndView mav,
			HttpServletRequest req){
		System.out.println("�û���֤ʧ�ܣ�");
		
		String msg=(String)req.getAttribute(
			FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		System.out.println("��֤ʧ����Ϣ�ǣ�"+msg);
		
		String fail="";
		if(msg!=null){
			if(msg.equals(UnknownAccountException.class.getName())){
				fail="unknown";//�û���������
			}else if(msg.equals(IncorrectCredentialsException.class.getName())){
				fail="error";//�������
			}else if(msg.equals("randomCodeError")){
				fail="code";//��֤�����
			}else{
				fail="other";//δ֪����
			}
		}
		
		mav.setViewName("redirect:../login.jsp?isfail="+fail);//������ͼ���ƣ��ض���login.jsp
		
		return mav;
	}
	
	//��֤�ɹ��ķ���
	@RequestMapping("/main.do") 
	public ModelAndView main(ModelAndView mav,
			HttpSession session){
		System.out.println("�û���֤�ɹ�");
		
		//��ȡ����
		Subject subject = SecurityUtils.getSubject();
		//��ȡͨ����֤���û�����
		SysUser sysUser=(SysUser)subject.getPrincipal();
		session.setAttribute("nowuser", sysUser);
		
		mav.setViewName("redirect:../main.jsp");
		return mav;
	}

}
