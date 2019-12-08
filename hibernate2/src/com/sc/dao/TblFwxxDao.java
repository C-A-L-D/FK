package com.sc.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

import com.sc.entity.TblFwxx;

public class TblFwxxDao {

	public List<TblFwxx> select() {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf";
		Query query = session.createQuery(hql);
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	//?表示占位符
	//模糊查询
	public List<TblFwxx> selectByTitle(String t) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf where tf.title like ?";
		Query query = session.createQuery(hql);
		query.setString(0, "%" + t + "%");
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	//使用> < == 表示范围
	public List<TblFwxx> selectByZj1(Long zj1, Long zj2) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf where tf.zj>? and tf.zj<? ";
		Query query = session.createQuery(hql);
		query.setLong(0, zj1);
		query.setLong(1, zj2);
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	//使用between and 表示范围
	public List<TblFwxx> selectByZj2(Long zj1, Long zj2) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf where tf.zj between ? and ? ";
		Query query = session.createQuery(hql);
		query.setLong(0, zj1);
		query.setLong(1, zj2);
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	//命名参数查询
	public List<TblFwxx> selectByZj3(Long zj1, Long zj2) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf where tf.zj between :z1 and :z2 ";
		Query query = session.createQuery(hql);
		query.setLong("z1", zj1);
		query.setLong("z2", zj2);
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	
	
	//关联查询（相当于内联结），外连接（全连接，左连接，右联结）
	
	
	
	/*
	 * setFirstResult 是起始数据，setMaxResults是查询显示的数据。
	 * pageNum 页码(当前页)
	 * pageSize 页长
	 */
	public List<TblFwxx> selectPage(int pageNum,int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf order by tf.fwid asc ";
		Query query = session.createQuery(hql);
		//在数据库分页（区别于query.scroll()根据在内存中的结果集进行分页----JDBC默认查出全部结果，然后scroll游标根据查出来再去分页）
		query.setFirstResult((pageNum-1)*pageSize); //设置当前页第一条数据的下标
		query.setMaxResults(pageSize); //设置当前页数据最大条数
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	/*
	 * 数据库中根据你的查询条件只会返回唯一结果，就可以用uniqueResult这个方法！否则就用list（）
	 */
	public int count() {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select count(tf) from TblFwxx as tf";
		Query query = session.createQuery(hql);
		long cou = (Long)query.uniqueResult();//单个结果（唯一结果）
		int c = (int)cou;
		session.close();
		
		return c;
	}
	
	/*
	 *					(name = "a" or name = "b") 
	 *	criteria.add(Restrictions.or(Restrictions.eq("name","a"),Restrictions.eq("name","b")));
	 *	如果有两个以上or，加一个disjunction()方法
	 *	Disjunction dis = Restrictions.disjunction();
	 *	dis.add(Restrictions.eq("name", "a"));
	 *	dis.add(Restrictions.eq("name", "b"));
	 *	dis.add(Restrictions.eq("name", "c"));
	 */
	public List<TblFwxx> search(TblFwxx fw) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblFwxx.class);
		
		//设置条件
		if (fw != null) {
			//标题模糊查询
			if (fw.getTitle() != null) {
				criteria.add(Restrictions.like("title", fw.getTitle(), MatchMode.ANYWHERE));
			}
			if (fw.getZj1() != null) {
				criteria.add(Restrictions.ge("zj1", fw.getZj1()));
			}
			if (fw.getZj2() != null) {
				criteria.add(Restrictions.le("zj2", fw.getZj2()));
			}
			if (fw.getLxids() != null) {
				criteria.add(Restrictions.in("lxid", fw.getLxids()));
			}
		}
		
		criteria.addOrder(Order.desc("fwid"));
		
		List<TblFwxx> list = criteria.list();
		session.close();
		return list;
	}
	
	//HQL                                                                                                                                                                                                                                                                                                                                                  
	public List<TblFwxx> search1(TblFwxx fw){
		 Session session = HibernateSessionFactory.getSession();
		 String hql="select fw from TblFwxx as fw where 1=1 ";
		 
         //设置条件
		 if(fw!=null){
			 //标题模糊查询
			 if(fw.getTitle()!=null){
				 hql+=" and fw.title like '%"+fw.getTitle()+"%'";
			 }
			 
			 //租金大于等于
			 if(fw.getZj1()!=null){
				 hql+=" and fw.zj>="+fw.getZj1();
			 }
			 
			//租金小于等于
			 if(fw.getZj2()!=null){
				 hql+=" and fw.zj<="+fw.getZj2();
			 }
			 
			//类型in列表
			 if(fw.getLxids()!=null){
				String s=Arrays.toString(fw.getLxids());
				System.out.println(s + "\n" + s.length());
				hql+=" and fw.lxid in ("+s.substring(1,s.length()-1)+")";
			 }
		 }
		 
		 //排序
		 hql+=" order by fw.title desc";
		 
		 Query query = session.createQuery(hql);
		 List<TblFwxx> list = query.list();
		 session.close();
		 return list;
	}
	
}
