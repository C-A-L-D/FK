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
		System.out.println("加入购物车成功！");
		mav.setViewName("test");// 路径是：/WEB-INF/test.jsp
		return mav;
	}
	
	@RequestMapping("/upload.do")
	public ModelAndView upload(ModelAndView mav,
			MultipartFile upload,
			HttpServletRequest req) throws IllegalStateException, IOException{
		System.out.println("开始上传文件");
		
		//如果用户选择文件，那么执行上传代码
		if(upload!=null){
			String filename=upload.getOriginalFilename();//文件名
			if(filename!=null&&!filename.equals("")){
				//获取upload文件夹所在路径
				String path=req.getSession().
						getServletContext().getRealPath("upload");
				//形如：26456456435.jpg
				filename=System.currentTimeMillis()
						+filename.substring(filename.lastIndexOf("."));
				//目的地文件对象
				File file=new File(path+"/"+filename);
				upload.transferTo(file);//转换存储文件
				
				//设置图片名称,页面显示图片
				mav.addObject("pic", filename);
			}
		}
		
		mav.setViewName("show");// 路径是：/WEB-INF/show.jsp
		return mav;
	}

}
