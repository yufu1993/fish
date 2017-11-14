package cn.itcast.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.category.entity.Category;

/**
 * 一级分类的持久层对象
 * @author 93449
 *
 */
public class CategoryDao extends HibernateDaoSupport{
	
	/**
	 * Dao 层查一级分类
	 * @return
	 */
	public List<Category> findAll() {
		
		String hql="from Category";
		
		List<Category> clist=this.getHibernateTemplate().find(hql);
		
		return clist;
	}
	
	//dao层保存一级分类
	public void save(Category category) {

		this.getHibernateTemplate().save(category);
	}

	//dao层 根据cid查询一级分类
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}
	
	//dao 删除一级分类
	public void delete(Category category) {
		
		this.getHibernateTemplate().delete(category);
	}
	
	//dao层修改一级分类的方法
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

	

}
