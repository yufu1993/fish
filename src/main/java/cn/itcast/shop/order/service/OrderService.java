package cn.itcast.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.order.dao.OrderDao;
import cn.itcast.shop.order.entity.Order;
import cn.itcast.shop.utils.PageBean;

/**
 * 订单模块：业务层代码
 * @author 93449
 *
 */
@Transactional
public class OrderService {
	//注入OrderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//保存订单的业务层代码
	public void save(Order order) {
		
		orderDao.save(order);
		
	}
	
	//我的订单的业务层代码
	public PageBean<Order> findByPageUid(Integer uid, Integer page) {

		PageBean<Order> pageBean = new PageBean<Order>();	
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数/
		Integer limit=5;
		pageBean.setLimit(limit);
		//设置总的记录数
		Integer totalCount=null;
		totalCount=orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		Integer totalPage=null;
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			totalPage = totalCount / limit+1;
		}
		pageBean.setTotalpage(totalPage);
		//设置每页显示的数据集合
		Integer begin = (page-1) * limit ;
		List<Order> list = orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//业务层：根据订单id查询订单的方法
	public Order findByOid(Integer oid) {
		
		Order order = orderDao.findByOid(oid);	
		
		return order;
	}
	
	//修改订单
	public void update(Order currOrder) {
		
		orderDao.update(currOrder);
		
	}
	
	
}
