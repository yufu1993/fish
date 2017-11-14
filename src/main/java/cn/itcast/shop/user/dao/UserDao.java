package cn.itcast.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.user.entity.User;

/**
 * �û�ģ��־ò����
 * @author 93449
 *
 */
public class UserDao extends HibernateDaoSupport{
	
	//�����Ʋ�ѯ�Ƿ��и��û�
	public User findByUserName(String username){
		
		String hql="from User where username=?";
		
		List<User> list=this.getHibernateTemplate().find(hql, username);
		
		if(list !=  null && list.size()>0){
			
			return list.get(0);
		}
		
		return null;
	}
	//ע���û��������ݿ�ʵ��
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}
	
	//���ݼ������ѯ�û�
	public User findByCode(String code) {
		
		String hql="from User where code=?";
		
		List<User> list=this.getHibernateTemplate().find(hql,code);
		
		if(list !=  null && list.size()>0){
			
			return list.get(0);
		}
		
		return null;
	}
	//�����û�״̬
	public void update(User exitUser) {
	
		this.getHibernateTemplate().update(exitUser);
		
	}
	//�û���½�ķ���
	public User login(User user) {
		String hql="from User where username=? and  password=? and state=?";
		
		List<User> list = this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		
		if(list != null && list.size()>0){
			
			return list.get(0);
		}
		
		return null;
	}
	
}
