package cn.itcast.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.order.entity.Order;
import cn.itcast.shop.utils.PageHibernateCallback;

/**
 * ����ģ�飺Dao��Ĵ���
 * @author 93449
 *
 */
public class OrderDao extends HibernateDaoSupport{
	
	//dao�㱣�涩��d�ķ���
	public void save(Order order) {
		
		this.getHibernateTemplate().save(order);
		
	}
	
	
	//DAO ���ҵĶ����ĸ���ͳ��
	public Integer findByCountUid(Integer uid) {

		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list =this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
		}
		
		return null;
	}
	
	//DAO �� �ҵĶ�������
	public  List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		
		String hql ="from Order o where o.user.uid= ? order by ordertime desc";
		
		List<Order> list  = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
		
		return list;
	}
	
	//���ݶ���id��ѯ����
	public Order findByOid(Integer oid) {
		
		
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	//�޸Ķ���
	public void update(Order currOrder) {

		this.getHibernateTemplate().update(currOrder);
	}

}
