package com.sc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.Users;

@Controller  //������ע�⣬ע��bean����Ĭ�϶���������������ĸСд
@RequestMapping("/loginctrl") //�������ӳ��url
public class LoginController {
	
	@RequestMapping("/login.do") //����������ӳ��url
	//�����ĵ�ַ�ǣ�http://localhost:8080/springmvc01/loginctrl/login.do
	public ModelAndView login(ModelAndView mav,
			Users user,HttpSession session){//���������ֵ�Զ���װ�����������
		System.out.println("��ʼ��¼����");
		System.out.println("�û�������Ϣ��"+user);
		
        //ģ���¼		
		if(user.getUname().equals("admin")&&
				user.getUpass().equals("123")){
			//��¼�ɹ�
			session.setAttribute("nowuser", user);//�û��������session
			mav.setViewName("redirect:../main.jsp");//�ض���������
		}else{
			//��¼ʧ��
			mav.setViewName("redirect:../login.jsp?isfail=yes");//������ͼ���ƣ��ض���login.jsp
		}
		
		return mav;
	}

}
