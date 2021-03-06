package cn.itcast.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.order.entity.Order;
import cn.itcast.shop.utils.PageHibernateCallback;

/**
 * 订单模块：Dao层的代码
 * @author 93449
 *
 */
public class OrderDao extends HibernateDaoSupport{
	
	//dao层保存订单d的方法
	public void save(Order order) {
		
		this.getHibernateTemplate().save(order);
		
	}
	
	
	//DAO 层我的订单的个数统计
	public Integer findByCountUid(Integer uid) {

		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list =this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0){
			
			return list.get(0).intValue();
		}
		
		return null;
	}
	
	//DAO 层 我的订单管理
	public  List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		
		String hql ="from Order o where o.user.uid= ? order by ordertime desc";
		
		List<Order> list  = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
		
		return list;
	}
	
	//根据订单id查询订单
	public Order findByOid(Integer oid) {
		
		
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	//修改订单
	public void update(Order currOrder) {

		this.getHibernateTemplate().update(currOrder);
	}

}
