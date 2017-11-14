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
 * ��Ʒ��DAO �����
 * @author 93449
 *
 */
public class ProductDao extends HibernateDaoSupport{
	
	//��ҳ������Ʒ��ѯ
	public List<Product> findHot() {
		//ʹ������������ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//��ѯ������Ʒ ������ is_host=1
		criteria.add(Restrictions.eq("is_hot", 1));
		//�����ڵ����������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}
	
	//��ҳ������Ʒ��ѯ
	public List<Product> findNew() {
		//ʹ������������ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//�����ڵ����������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> nList = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		
		return nList;
	}
	
	//������Ʒid��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	
	//����һ������id��ѯ��Ʒ�ĸ���
	public int findCountCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
			
		}
		return 0;
	}
	
	//����һ������id��ѯÿҳ��Ʒ�ļ���
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		//��ҳ����һ��д��
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,new Object[]{cid}, begin, limit));
		if(list != null && list.size() > 0){
			
			return list;
		}
		return null;
	}
	
	//���ݶ�������id��ѯ��Ʒ����
	public int findCountCsid(Integer csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list = this.getHibernateTemplate().find(hql,csid);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
			
		}
		return 0;
		
	}
	
	//���ݶ�������id��ѯÿҳ��Ʒ�ļ���
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		if(list != null && list.size() > 0){
			
			return list;
		}
		return null;
	}
	
	//��ѯ��Ʒ������
	public int findCount() {
		String hql ="select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
			
		}
		return 0;
	}
	
	//��̨����ҳ��ѯ��Ʒ�ķ���
	public List<Product> findByPage(int begin, int limit) {
		
		String hql="from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		if(list != null && list.size()>0){
			
			 return list;
		}
		return null;
	}
	
	//DAO ������Ʒ�ķ���
	public void save(Product product) {
		
		this.getHibernateTemplate().save(product);
	}
	
	//DAO��ɾ����Ʒ�ķ���
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	
	
}
