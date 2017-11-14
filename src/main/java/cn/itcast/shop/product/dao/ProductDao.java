package cn.itcast.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.product.entity.Product;
import cn.itcast.shop.utils.PageHibernateCallback;

/**
 * 商品的DAO 层代码
 * @author 93449
 *
 */
public class ProductDao extends HibernateDaoSupport{
	
	//首页热门商品查询
	public List<Product> findHot() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门商品 条件是 is_host=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//按日期倒序排序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}
	
	//首页最新商品查询
	public List<Product> findNew() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//按日期倒序排序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> nList = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		
		return nList;
	}
	
	//根据商品id查询商品
	public Product findByPid(Integer pid) {
		
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	
	//根据一级分类id查询商品的个数
	public int findCountCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
			
		}
		return 0;
	}
	
	//根据一级分类id查询每页商品的集合
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		//分页的另一种写法
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			
			return list;
		}
		return null;
	}
	
	//根据二级分类id查询商品个数
	public int findCountCsid(Integer csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list = this.getHibernateTemplate().find(hql,csid);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
			
		}
		return 0;
		
	}
	
	//根据二级分类id查询每页商品的集合
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		if(list != null && list.size() > 0){
			
			return list;
		}
		return null;
	}
	
	//查询商品的总数
	public int findCount() {
		String hql ="select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
			
		}
		return 0;
	}
	
	//后台带分页查询商品的方法
	public List<Product> findByPage(int begin, int limit) {
		
		String hql="from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		if(list != null && list.size()>0){
			
			 return list;
		}
		return null;
	}
	
	//DAO 保存商品的方法
	public void save(Product product) {
		
		this.getHibernateTemplate().save(product);
	}
	
	//DAO层删除商品的方法
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	
	
}
