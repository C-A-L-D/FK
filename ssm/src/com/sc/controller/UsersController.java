package com.sc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.Users;
import com.sc.service.UsersService;

@Controller
@RequestMapping("/usersctrl")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping("/list.do")
	public ModelAndView list(ModelAndView mav){
		System.out.println("��ѯ�û��б�");
		
		//��ѯlist����
		List<Users> list = this.usersService.select();
		mav.addObject("list", list);//list���ϴ���ģ��
		mav.setViewName("userslist");// ·���ǣ�/WEB-INF/userslist.jsp
		return mav;
	}
	
	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav, @RequestParam(defaultValue="1")Integer pageNum,  @RequestParam(defaultValue="5")Integer pageSize){
		System.out.println("��ѯ�û���ҳ�б�");
		
		//��ѯlist����-��ҳ
		PageInfo<Users> page = this.usersService.selectPage(pageNum, pageSize);
		mav.addObject("p", page);//list���ϴ���ģ��
		mav.setViewName("userslistPage");// ·���ǣ�/WEB-INF/userslistPages.jsp
		return mav;
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(ModelAndView mav,Users u){
		System.out.println("ɾ���û���"+u);
		this.usersService.delete(u);
		mav.setViewName("redirect:list.do");//�ض���list����
		return mav;
	}
	
	@RequestMapping("/goupdate.do")
	public ModelAndView goupdate(ModelAndView mav,Users u){
		System.out.println("��ת���޸�ҳ�棡"+u);
		Users users = this.usersService.get(u.getUid());
		mav.addObject("u", users);
		mav.setViewName("usersupdate");
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav,
			MultipartFile upload,
			HttpServletRequest req,
			Users u) throws IllegalStateException, IOException{
		System.out.println("��ʼ�ϴ��ļ�"+u);
		
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
				
				//����ͼƬ����
				u.setPic(filename);
			}
		}
		
		this.usersService.update(u);
		mav.setViewName("redirect:list.do");//�ض���list����
		return mav;
	}

}
