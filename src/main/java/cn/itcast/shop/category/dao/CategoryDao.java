package cn.itcast.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.category.entity.Category;

/**
 * һ������ĳ־ò����
 * @author 93449
 *
 */
public class CategoryDao extends HibernateDaoSupport{
	
	/**
	 * Dao ���һ������
	 * @return
	 */
	public List<Category> findAll() {
		
		String hql="from Category";
		
		List<Category> clist=this.getHibernateTemplate().find(hql);
		
		return clist;
	}
	
	//dao�㱣��һ������
	public void save(Category category) {

		this.getHibernateTemplate().save(category);
	}

	//dao�� ����cid��ѯһ������
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}
	
	//dao ɾ��һ������
	public void delete(Category category) {
		
		this.getHibernateTemplate().delete(category);
	}
	
	//dao���޸�һ������ķ���
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

	

}
