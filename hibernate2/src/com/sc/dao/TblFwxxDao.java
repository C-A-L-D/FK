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
	
	//?��ʾռλ��
	//ģ����ѯ
	public List<TblFwxx> selectByTitle(String t) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf where tf.title like ?";
		Query query = session.createQuery(hql);
		query.setString(0, "%" + t + "%");
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	//ʹ��> < == ��ʾ��Χ
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
	
	//ʹ��between and ��ʾ��Χ
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
	
	//����������ѯ
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
	
	
	
	//������ѯ���൱�������ᣩ�������ӣ�ȫ���ӣ������ӣ������ᣩ
	
	
	
	/*
	 * setFirstResult ����ʼ���ݣ�setMaxResults�ǲ�ѯ��ʾ�����ݡ�
	 * pageNum ҳ��(��ǰҳ)
	 * pageSize ҳ��
	 */
	public List<TblFwxx> selectPage(int pageNum,int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select tf from TblFwxx as tf order by tf.fwid asc ";
		Query query = session.createQuery(hql);
		//�����ݿ��ҳ��������query.scroll()�������ڴ��еĽ�������з�ҳ----JDBCĬ�ϲ��ȫ�������Ȼ��scroll�α���ݲ������ȥ��ҳ��
		query.setFirstResult((pageNum-1)*pageSize); //���õ�ǰҳ��һ�����ݵ��±�
		query.setMaxResults(pageSize); //���õ�ǰҳ�����������
		List<TblFwxx> list = query.list();
		session.close();
		
		return list;
	}
	
	/*
	 * ���ݿ��и�����Ĳ�ѯ����ֻ�᷵��Ψһ������Ϳ�����uniqueResult����������������list����
	 */
	public int count() {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select count(tf) from TblFwxx as tf";
		Query query = session.createQuery(hql);
		long cou = (Long)query.uniqueResult();//���������Ψһ�����
		int c = (int)cou;
		session.close();
		
		return c;
	}
	
	/*
	 *					(name = "a" or name = "b") 
	 *	criteria.add(Restrictions.or(Restrictions.eq("name","a"),Restrictions.eq("name","b")));
	 *	�������������or����һ��disjunction()����
	 *	Disjunction dis = Restrictions.disjunction();
	 *	dis.add(Restrictions.eq("name", "a"));
	 *	dis.add(Restrictions.eq("name", "b"));
	 *	dis.add(Restrictions.eq("name", "c"));
	 */
	public List<TblFwxx> search(TblFwxx fw) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(TblFwxx.class);
		
		//��������
		if (fw != null) {
			//����ģ����ѯ
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
		 
         //��������
		 if(fw!=null){
			 //����ģ����ѯ
			 if(fw.getTitle()!=null){
				 hql+=" and fw.title like '%"+fw.getTitle()+"%'";
			 }
			 
			 //�����ڵ���
			 if(fw.getZj1()!=null){
				 hql+=" and fw.zj>="+fw.getZj1();
			 }
			 
			//���С�ڵ���
			 if(fw.getZj2()!=null){
				 hql+=" and fw.zj<="+fw.getZj2();
			 }
			 
			//����in�б�
			 if(fw.getLxids()!=null){
				String s=Arrays.toString(fw.getLxids());
				System.out.println(s + "\n" + s.length());
				hql+=" and fw.lxid in ("+s.substring(1,s.length()-1)+")";
			 }
		 }
		 
		 //����
		 hql+=" order by fw.title desc";
		 
		 Query query = session.createQuery(hql);
		 List<TblFwxx> list = query.list();
		 session.close();
		 return list;
	}
	
}
