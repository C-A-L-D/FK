package com.sc.test;

import java.util.List;

import com.sc.dao.TblFwxxDao;
import com.sc.entity.TblFwxx;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TblFwxxDao dao = new TblFwxxDao();
//		List<TblFwxx> list = dao.select();
//		List<TblFwxx> list = dao.selectByTitle("一");
//		List<TblFwxx> list = dao.selectByZj1(2000L, 3000L);
//		List<TblFwxx> list = dao.selectByZj2(2000L, 3000L);
//		List<TblFwxx> list = dao.selectByZj3(2000L, 3000L);
		List<TblFwxx> list = dao.selectPage(3, 4);
/*		for (TblFwxx t : list) {
			System.out.println(t.toString());
		}
		
		System.out.println("总条数：" + dao.count());
		TblFwxx fw=new TblFwxx();
		fw.setTitle("出租");
	    fw.setZj1(2000L);
	    fw.setZj2(2400L);
	    fw.setLxids(new Integer[]{4,1,2,5});
		List<TblFwxx> list2 = dao.search1(fw);
		for (TblFwxx tblFwxx : list2) {
			System.out.println(tblFwxx);
			//System.out.println(tblFwxx.getDate()+"\t"+tblFwxx.getTitle());
		}*/
		TblFwxx t = new TblFwxx();
		//测试了一个SQL注入
		t.setTitle("北%\' and fw.fwid like \'%6");
		List<TblFwxx> search1 = dao.search1(t);
		for (TblFwxx tblFwxx : search1) {
			System.out.println(tblFwxx);
		}
	}

}
