package com.sc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usersctrl")
public class UsersController {
	
	@RequestMapping("/test.do")
	public ModelAndView test(ModelAndView mav){
		System.out.println("���빺�ﳵ�ɹ���");
		mav.setViewName("test");// ·���ǣ�/WEB-INF/test.jsp
		return mav;
	}
	
	@RequestMapping("/upload.do")
	public ModelAndView upload(ModelAndView mav,
			MultipartFile upload,
			HttpServletRequest req) throws IllegalStateException, IOException{
		System.out.println("��ʼ�ϴ��ļ�");
		
		//����û�ѡ���ļ�����ôִ���ϴ�����
		if(upload!=null){
			String filename=upload.getOriginalFilename();//�ļ���
			if(filename!=null&&!filename.equals("")){
				//��ȡupload�ļ�������·��
				String path=req.getSession().
						getServletContext().getRealPath("upload");
				//���磺26456456435.jpg
				filename=System.currentTimeMillis()
						+filename.substring(filename.lastIndexOf("."));
				//Ŀ�ĵ��ļ�����
				File file=new File(path+"/"+filename);
				upload.transferTo(file);//ת���洢�ļ�
				
				//����ͼƬ����,ҳ����ʾͼƬ
				mav.addObject("pic", filename);
			}
		}
		
		mav.setViewName("show");// ·���ǣ�/WEB-INF/show.jsp
		return mav;
	}

}
